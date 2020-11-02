package dk.sds.nsp.maternity.data.utils;

import javax.servlet.http.HttpServletRequest;

public class PatientContext {

    public static String extractPatientIdentifierFromSession(HttpServletRequest from){
        if(from != null && from.getSession() != null && from.getSession().getAttribute("cpr") != null)
        {
            return (String) from.getSession().getAttribute("cpr");
        }
        return  "1234567890";
    }
}
