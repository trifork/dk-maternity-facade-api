package dk.sds.maternity.saml.auth.servlets;


import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static dk.sds.maternity.saml.auth.Constants.SESSION_CPR;

/**
 * 
 * @author jso
 */
@SuppressWarnings("serial")
@WebServlet("/sbov2")
public class SBOV2Login extends HttpServlet {

    private static final Logger log = Logger.getLogger(SBOV2Login.class);


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("saml/SAMLAssertionConsumer").forward(req, resp);

        HttpSession session = req.getSession();

        if (session != null) {
            final String cpr = req.getParameter(SESSION_CPR);
            if (cpr != null) {
                session.setAttribute(SESSION_CPR, cpr);
            }
        }
    }

}
