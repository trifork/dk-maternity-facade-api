package dk.sds.maternity.saml.auth;

import dk.itst.oiosaml.common.OIOSAMLConstants;
import dk.itst.oiosaml.configuration.OIOSAMLBootstrap;
import dk.itst.oiosaml.configuration.SAMLConfiguration;
import dk.itst.oiosaml.configuration.SAMLConfigurationFactory;
import dk.itst.oiosaml.logging.Audit;
import dk.itst.oiosaml.logging.Logger;
import dk.itst.oiosaml.logging.LoggerFactory;
import dk.itst.oiosaml.logging.Operation;
import dk.itst.oiosaml.sp.UserAssertion;
import dk.itst.oiosaml.sp.UserAssertionHolder;
import dk.itst.oiosaml.sp.develmode.DevelMode;
import dk.itst.oiosaml.sp.develmode.DevelModeImpl;
import dk.itst.oiosaml.sp.metadata.CRLChecker;
import dk.itst.oiosaml.sp.metadata.IdpMetadata;
import dk.itst.oiosaml.sp.metadata.SPMetadata;
import dk.itst.oiosaml.sp.service.SAMLHttpServletRequest;
import dk.itst.oiosaml.sp.service.SPFilter;
import dk.itst.oiosaml.sp.service.session.Request;
import dk.itst.oiosaml.sp.service.session.SessionCleaner;
import dk.itst.oiosaml.sp.service.session.SessionHandler;
import dk.itst.oiosaml.sp.service.session.SessionHandlerFactory;
import dk.itst.oiosaml.sp.service.util.Constants;
import org.apache.commons.configuration.Configuration;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.xml.security.BasicSecurityConfiguration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomSPFilter extends SPFilter {
    private final List<String> skipSPFilterPaths = Arrays.asList(
            "/youAreLoggedOut",
            "/isAlive"
    );

    private static final Logger log = LoggerFactory.getLogger(SPFilter.class);
    private CRLChecker crlChecker = new CRLChecker();
    private boolean filterInitialized;
    private SAMLConfiguration conf;
    private String hostname;
    private SessionHandlerFactory sessionHandlerFactory;
    private AtomicBoolean cleanerRunning = new AtomicBoolean(false);
    private DevelMode develMode;


    /**
     * Static initializer for bootstrapping OpenSAML.
     *
     * ... we need this in both SPFilter and DispatcherServlet as the order of creation of these two depends on the servlet container
     */
    static {
        OIOSAMLBootstrap.init();
    }

    public void destroy() {
        SessionCleaner.stopCleaner();
        crlChecker.stopChecker();
        if (sessionHandlerFactory != null) {
            sessionHandlerFactory.close();
        }
        SessionHandlerFactory.Factory.close();
    }

    /**
     * Check whether the user is authenticated i.e. having session with a valid
     * assertion. If the user is not authenticated an &lt;AuthnRequest&gt; is
     * sent to the Login Site.
     *
     * @param request  The servletRequest
     * @param response The servletResponse
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (log.isDebugEnabled()) {
            log.debug("OIOSAML-J SP Filter invoked");
        }

        if (!(request instanceof HttpServletRequest)) {
            throw new RuntimeException("Not supported operation...");
        }

        HttpServletRequest servletRequest = ((HttpServletRequest) request);
        if (skipSPFilterPaths.stream().anyMatch(path -> servletRequest.getRequestURI().startsWith(path))) {
            chain.doFilter(request, response);
            return;
        }

        Audit.init(servletRequest);

        if (!isFilterInitialized()) {
            try {
                Configuration config = SAMLConfigurationFactory.getConfiguration().getSystemConfiguration();
                setRuntimeConfiguration(config);
            } catch (IllegalStateException e) {
                request.getRequestDispatcher("/saml/configure").forward(request, response);
                return;
            }
        }

        // Other libraries/frameworks might reset/overwrite our signature algorithm setting,
        // so to ensure that we always use the configured setting for all requests, we set
        // the signature algorithm on the configuration on every single request.
        ensureSignatureAlgorithm();

        if (conf.getSystemConfiguration().getBoolean(Constants.PROP_DEVEL_MODE, false)) {
            log.warn("Running in debug mode, skipping regular filter");
            develMode.doFilter(servletRequest, (HttpServletResponse) response, chain, conf.getSystemConfiguration());
            return;
        }

        if (cleanerRunning.compareAndSet(false, true)) {
            SessionCleaner.startCleaner(sessionHandlerFactory.getHandler(), ((HttpServletRequest) request).getSession().getMaxInactiveInterval(), 30);
        }

        SessionHandler sessionHandler = sessionHandlerFactory.getHandler();
        if (servletRequest.getServletPath().equals(conf.getSystemConfiguration().getProperty(Constants.PROP_SAML_SERVLET))) {
            log.debug("Request to SAML servlet, access granted");
            chain.doFilter(new SAMLHttpServletRequest(servletRequest, hostname, null), response);
            return;
        }
        final HttpSession session = servletRequest.getSession();
        if (log.isDebugEnabled())
            log.debug("sessionId....:" + session.getId()
            );

        boolean forceAuthn = false;
        if (request.getParameterMap().containsKey(Constants.QUERY_STRING_FORCE_AUTHN)) {
            String forceAuthnAsString = request.getParameter(Constants.QUERY_STRING_FORCE_AUTHN);
            forceAuthn = forceAuthnAsString.toLowerCase().equals("true");
        }

        // Is the user logged in?
        if (sessionHandler.isLoggedIn(session.getId()) && session.getAttribute(Constants.SESSION_USER_ASSERTION) != null && !forceAuthn) {

            // enforce configured minimum Assurance/NSIS level
            validateAssuranceLevel(sessionHandler, session);

            // validate chosen profile
            validateProfile(sessionHandler, session);

            UserAssertion ua = (UserAssertion) session.getAttribute(Constants.SESSION_USER_ASSERTION);
            if (log.isDebugEnabled()) {
                log.debug("Everything is ok... Assertion: " + ua);
            }

            Audit.log(Operation.ACCESS, servletRequest.getRequestURI());

            // perform actual request
            try {
                UserAssertionHolder.set(ua);

                HttpServletRequestWrapper requestWrap = new SAMLHttpServletRequest(servletRequest, ua, hostname);
                chain.doFilter(requestWrap, response);

                return;
            } finally {
                UserAssertionHolder.set(null);
            }
        }

        // perform login action
        session.removeAttribute(Constants.SESSION_USER_ASSERTION);
        UserAssertionHolder.set(null);
        saveRequestAndGotoLogin((HttpServletResponse) response, servletRequest);
    }

    private void validateProfile(SessionHandler sessionHandler, HttpSession session) {
        String profile = conf.getSystemConfiguration().getString(Constants.PROP_REQUESTED_PROFILE, null);
        if (profile != null) {
            if (OIOSAMLConstants.PROFILE_PERSON.equals(profile)) {
                ; // no validation required
            } else if (OIOSAMLConstants.PROFILE_PROFESSIONAL.equals(profile)) {
                boolean foundCvr = false, foundOrgName = false;

                Assertion assertion = sessionHandler.getAssertion(session.getId()).getAssertion();
                for (AttributeStatement attributeStatement : assertion.getAttributeStatements()) {
                    for (Attribute attribute : attributeStatement.getAttributes()) {
                        if (OIOSAMLConstants.ATTRIBUTE_EID_PROFESSIONAL_CVR.equals(attribute.getName())) {
                            foundCvr = true;
                        } else if (OIOSAMLConstants.ATTRIBUTE_EID_PROFESSIONAL_ORGNAME.equals(attribute.getName())) {
                            foundOrgName = true;
                        }
                    }
                }

                if (!foundCvr || !foundOrgName) {
                    sessionHandler.logOut(session);

                    throw new RuntimeException("Mandatory attributes for professional profile not present: " + ((!foundCvr) ? OIOSAMLConstants.ATTRIBUTE_EID_PROFESSIONAL_CVR : "") + " " + ((!foundOrgName) ? OIOSAMLConstants.ATTRIBUTE_EID_PROFESSIONAL_ORGNAME : ""));
                }
            } else {
                log.warn("Unknown profile: " + profile);
            }
        }
    }

    private void validateAssuranceLevel(SessionHandler sessionHandler, HttpSession session) {
        int actualAssuranceLevel = sessionHandler.getAssertion(session.getId()).getAssuranceLevel();
        String actualNSISLevel = sessionHandler.getAssertion(session.getId()).getNSISLevel();

        int requiredAssuranceLevel = conf.getSystemConfiguration().getInt(Constants.PROP_ASSURANCE_LEVEL, 0);
        String requiredNSISLevel = conf.getSystemConfiguration().getString(Constants.PROP_NSIS_LEVEL, null);

        boolean valid = false;
        if (requiredAssuranceLevel == 0 && requiredNSISLevel == null) {
            valid = true;
        } else if (requiredAssuranceLevel > 0 && actualAssuranceLevel >= requiredAssuranceLevel) {
            valid = true;
        } else if (requiredNSISLevel != null && actualNSISLevel != null) {
            if (requiredNSISLevel.equals(OIOSAMLConstants.NSIS_REQUEST_LEVEL_HIGH)) {
                if (actualNSISLevel.equals(OIOSAMLConstants.NSIS_RESPONSE_LEVEL_HIGH)) {
                    valid = true;
                }
            } else if (requiredNSISLevel.equals(OIOSAMLConstants.NSIS_REQUEST_LEVEL_SUBSTANTIAL)) {
                if (actualNSISLevel.equals(OIOSAMLConstants.NSIS_RESPONSE_LEVEL_HIGH) ||
                        actualNSISLevel.equals(OIOSAMLConstants.NSIS_RESPONSE_LEVEL_SUBSTANTIAL)) {
                    valid = true;
                }
            } else if (requiredNSISLevel.equals(OIOSAMLConstants.NSIS_REQUEST_LEVEL_LOW)) {
                if (actualNSISLevel.equals(OIOSAMLConstants.NSIS_RESPONSE_LEVEL_HIGH) ||
                        actualNSISLevel.equals(OIOSAMLConstants.NSIS_RESPONSE_LEVEL_SUBSTANTIAL) ||
                        actualNSISLevel.equals(OIOSAMLConstants.NSIS_RESPONSE_LEVEL_LOW)) {
                    valid = true;
                }
            }
        }

        if (!valid) {
            sessionHandler.logOut(session);

            String msg;
            if (requiredNSISLevel != null && requiredAssuranceLevel == 0) {
                msg = "NSIS level too low: " + actualNSISLevel + ", required: " + requiredNSISLevel;
            } else if (requiredNSISLevel == null && requiredAssuranceLevel > 0) {
                msg = "Assurance level too low: " + actualAssuranceLevel + ", required: " + requiredAssuranceLevel;
            } else {
                msg = "Both NSIS level and Assurance level where too low: " + actualAssuranceLevel + " / " + actualNSISLevel + ", required: " + requiredAssuranceLevel + " / " + requiredNSISLevel;
            }

            log.warn(msg);
            throw new RuntimeException(msg);
        }
    }

    protected void saveRequestAndGotoLogin(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        SessionHandler sessionHandler = sessionHandlerFactory.getHandler();
        String relayState = sessionHandler.saveRequest(Request.fromHttpRequest(request));
        String protocol = conf.getSystemConfiguration().getString(Constants.PROP_PROTOCOL, "saml20");
        String loginUrl = conf.getSystemConfiguration().getString(Constants.PROP_SAML_SERVLET, "/saml");
        String protocolUrl = conf.getSystemConfiguration().getString(Constants.PROP_PROTOCOL + "." + protocol);
        if (protocolUrl == null) {
            throw new RuntimeException("No protocol url configured for " + Constants.PROP_PROTOCOL + "." + protocol);
        }
        loginUrl += protocolUrl;
        if (log.isDebugEnabled())
            log.debug("Redirecting to " + protocol + " login handler at " + loginUrl);
        RequestDispatcher dispatch = request.getRequestDispatcher(loginUrl);
        dispatch.forward(new SAMLHttpServletRequest(request, hostname, relayState), response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        conf = SAMLConfigurationFactory.getConfiguration();

        if (conf.isConfigured()) {
            try {
                Configuration config = SAMLConfigurationFactory.getConfiguration().getSystemConfiguration();
                if (config.getBoolean(Constants.PROP_DEVEL_MODE, false)) {
                    develMode = new DevelModeImpl();
                    setConfiguration(config);
                    setFilterInitialized(true);
                    return;
                }
                setRuntimeConfiguration(config);
                setFilterInitialized(true);
                return;
            } catch (IllegalStateException e) {
                log.error("Unable to configure", e);
            }
        }
        setFilterInitialized(false);
    }

    private void setRuntimeConfiguration(Configuration conf) {
        restartCRLChecker(conf);
        setFilterInitialized(true);
        setConfiguration(conf);
        if (!IdpMetadata.getInstance().enableDiscovery()) {
            log.info("Discovery profile disabled, only one metadata file found");
        } else {
            if (conf.getString(Constants.DISCOVERY_LOCATION) == null) {
                throw new IllegalStateException("Discovery location cannot be null when discovery profile is active");
            }
        }
        setHostname();
        sessionHandlerFactory = SessionHandlerFactory.Factory.newInstance(conf);
        sessionHandlerFactory.getHandler().resetReplayProtection(conf.getInt(Constants.PROP_NUM_TRACKED_ASSERTIONIDS));

        ensureSignatureAlgorithm();

        log.info("Home url: " + conf.getString(Constants.PROP_HOME));
        log.info("Assurance level: " + conf.getInt(Constants.PROP_ASSURANCE_LEVEL));
        log.info("SP entity ID: " + SPMetadata.getInstance().getEntityID());
        log.info("Base hostname: " + hostname);
    }

    private static void ensureSignatureAlgorithm() {
        Configuration localConfig = SAMLConfigurationFactory.getConfiguration().getSystemConfiguration();
        BasicSecurityConfiguration samlConfig = (BasicSecurityConfiguration) org.opensaml.Configuration.getGlobalSecurityConfiguration();

        samlConfig.registerSignatureAlgorithmURI("RSA", localConfig.getString(Constants.SIGNATURE_ALGORITHM, "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"));
    }

    private void setHostname() {
        String url = SPMetadata.getInstance().getDefaultAssertionConsumerService().getLocation();
        setHostname(url.substring(0, url.indexOf('/', 8)));
    }

    private void restartCRLChecker(Configuration config) {
        crlChecker.stopChecker();
        int period = config.getInt(Constants.PROP_CRL_CHECK_PERIOD, 600);
        if (period > 0) {
            crlChecker.startChecker(period, IdpMetadata.getInstance(), config);
        } else {
            log.warn("Revocation check of IdP certificates has been disabled. All certificates including self signed certificates will be considered valid.");
            crlChecker.setAllCertificatesValid(IdpMetadata.getInstance());
        }
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setFilterInitialized(boolean b) {
        filterInitialized = b;
    }

    public boolean isFilterInitialized() {
        return filterInitialized;
    }

    public void setConfiguration(Configuration configuration) {
        SAMLConfigurationFactory.getConfiguration().setConfiguration(configuration);
        conf = SAMLConfigurationFactory.getConfiguration();
    }

    public void setSessionHandlerFactory(SessionHandlerFactory sessionHandlerFactory) {
        this.sessionHandlerFactory = sessionHandlerFactory;
    }

    public void setDevelMode(DevelMode develMode) {
        this.develMode = develMode;
    }


}
