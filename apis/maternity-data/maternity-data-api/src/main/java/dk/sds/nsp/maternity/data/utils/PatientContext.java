package dk.sds.nsp.maternity.data.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class PatientContext {

    /**
     * Extracts the cpr of the patient in context from a {@link HttpServletRequest}.
     * @throws IllegalArgumentException if no such cpr can be found
     * unless the environment variable {@code maternity_application_mode} is set to 'dev'.
     * In that case we DO NOT throw an exception - instead we return {@code "9949653695"} to
     * "fake" a session to ease development
     */
    public static String extractPatientIdentifierFromSession(HttpServletRequest from){
        if(from != null && from.getSession() != null) {
            Optional<String> cpr = Optional.ofNullable((String) from.getSession().getAttribute("cpr"));
            if (cpr.isPresent()) {
                return cpr.get();
            } else if ("dev".equalsIgnoreCase(System.getenv("maternity_application_mode"))) {
                return "9949653695"; // In development mode we'd like to not rely on a mutable, semi-global state
            } else {
                throw new IllegalArgumentException("Session MUST contain CPR");
            }
        }
        throw new IllegalArgumentException("Request must contain a session...");
    }
}
