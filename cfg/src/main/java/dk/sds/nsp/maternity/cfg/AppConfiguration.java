package dk.sds.nsp.maternity.cfg;

import org.apache.log4j.Logger;
import java.io.InputStream;
import java.util.Properties;

public class AppConfiguration {
    private static final String CONF_PATH = "/maternity-facade.properties";
    private static final Logger LOGGER = Logger.getLogger(AppConfiguration.class);

    private final Properties props = new Properties();

    public void init() {
        try {
            InputStream is = AppConfiguration.class.getResourceAsStream(CONF_PATH);
            props.load(is);
        } catch (Exception e) {
           throw new RuntimeException("Initialization Error", e);
        }
    }


    public String getContextJwtSecret() {
        return props.getProperty("contextJwtSecret");
    }

}
