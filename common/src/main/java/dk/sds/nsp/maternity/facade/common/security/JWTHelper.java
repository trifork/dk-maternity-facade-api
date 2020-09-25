package dk.sds.nsp.maternity.facade.common.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dk.sds.nsp.maternity.facade.common.exception.ProblemDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JWTHelper {

    private final Algorithm algorithm;

    @Autowired
    public JWTHelper(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public DecodedJWT verify(final String token) {
        try {
            return JWT.require(algorithm).build().verify(token);
        } catch (JWTVerificationException e) {
            throw ProblemDetails.unauthorized();
        }
    }

    public String sign(final JWTCreator.Builder jwt) {
        return jwt.sign(algorithm);
    }
}
