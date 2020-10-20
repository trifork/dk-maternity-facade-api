package dk.sds.nsp.maternity.auth.model;

import javax.xml.soap.SOAPMessage;

public class DGWSCredentials implements Credentials{
    @Override
    public <T extends SOAPMessage> T apply(T message) {
        return null;
    }
}
