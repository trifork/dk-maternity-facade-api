package dk.sds.nsp.maternity.data.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import dk.sds.nsp.maternity.facade.common.exception.ProblemDetailsException;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
import dk.sds.nsp.maternity.data.exception.ProblemDetailsExceptions;
import dk.sds.nsp.maternity.data.spring.ApplicationContextQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ApplicationContextQualifier
public class ApplicationContextJWTHelper extends JWTHelper {

    @Autowired
    public ApplicationContextJWTHelper(@ApplicationContextQualifier Algorithm algorithm) {
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
