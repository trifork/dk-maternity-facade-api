package dk.sds.nsp.maternity.facade.maternity.security;

import com.auth0.jwt.algorithms.Algorithm;
import dk.sds.nsp.maternity.facade.common.security.JWTHelper;
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
}
