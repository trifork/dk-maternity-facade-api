package dk.sds.nsp.maternity.cfg;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

public class Log4JConfigurator {

    public static final String CONFIGURATION_FILE = "log4j-maternity.xml";

    void configure() {
        final URL url = Log4JConfigurator.class.getClassLoader().getResource(CONFIGURATION_FILE);
        if(url == null) {
            try {
                BasicConfigurator.configure();
                Logger.getLogger(Log4JConfigurator.class).warn(String.format("Failed to resolve configuration %s, using basic configurator", CONFIGURATION_FILE));
                return;
            } catch (Exception e) {
                throw new IllegalStateException("Could not configure Log4J from basic configurator", e);
            }
        }

        final String externalForm = url.toExternalForm();
        try {
            DOMConfigurator.configure(url);
            Logger.getLogger(Log4JConfigurator.class).info(String.format("Log4J configured from classpath: %s", externalForm));
        } catch (Exception e) {
            throw new IllegalStateException(String.format("Could not configure Log4J from %s", externalForm), e);
        }
    }
}
