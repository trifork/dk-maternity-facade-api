package dk.sds.nsp.maternity.facade.maternity.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import dk.sds.nsp.maternity.facade.common.exception.ProblemDetailsException;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
import dk.sds.nsp.maternity.facade.maternity.exception.ProblemDetailsExceptions;
import dk.sds.nsp.maternity.facade.maternity.spring.SessionContextQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@SessionContextQualifier
public class SessionContextJWTHelper extends JWTHelper {

    @Autowired
    public SessionContextJWTHelper(@SessionContextQualifier Algorithm algorithm) {
        super(algorithm);
    }

    @Override
    public DecodedJWT verify(String token) {
        try {
            return super.verify(token);
        } catch (ProblemDetailsException e) {
            // Unwrap cause and wrap again
            throw ProblemDetailsExceptions.signatureCheckFailed(e.getCause());
        }
    }
}
