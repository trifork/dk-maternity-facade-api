package dk.sds.nsp.maternity.auth.model;

import javax.xml.soap.SOAPMessage;

public interface Credentials {

    <T extends SOAPMessage> T apply (T message);
}
