package dk.sds.nsp.maternity.data.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class PatientContext {

    public static String extractPatientIdentifierFromSession(HttpServletRequest from){
        if(from != null && from.getSession() != null) {
            return Optional.ofNullable((String) from.getSession().getAttribute("cpr"))
                    .orElseThrow(() -> new IllegalArgumentException("Session MUST contain CPR"));
        }
        throw new IllegalArgumentException("Request must contain a session...");
    }
}
