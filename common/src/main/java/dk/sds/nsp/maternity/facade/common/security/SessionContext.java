package dk.sds.nsp.maternity.facade.common.security;

import dk.sds.nsp.maternity.facade.common.model.ApplicationMode;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * SessionContextPayload
 */
@SuppressWarnings("unused")
public class SessionContext {
    public static final String PATIENT_IDENTIFIER_CLAIM_NAME = "patientIdentifier";
    public static final String APPLICATION_MODE_CLAIM_NAME = "applicationMode";
    public static final String BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME = "breakTheGlassExpiration";

    public static SessionContextBuilder withPatientIdentifier(final String patientIdentifier) { return new SessionContextBuilder().withPatientIdentifier(patientIdentifier); }
    public static SessionContextBuilder withApplicationMode(final ApplicationMode applicationMode) { return new SessionContextBuilder().withApplicationMode(applicationMode); }
    public static SessionContextBuilder withBreakTheGlassExpiration(final LocalDateTime breakTheGlassExpiration) { return new SessionContextBuilder().withBreakTheGlassExpiration(breakTheGlassExpiration); }

    private final String patientIdentifier;
    private final ApplicationMode applicationMode;
    private final LocalDateTime breakTheGlassExpiration;

    private SessionContext(String patientIdentifier, ApplicationMode applicationMode, LocalDateTime breakTheGlassExpiration) {
        this.patientIdentifier = patientIdentifier;
        this.applicationMode = applicationMode;
        this.breakTheGlassExpiration = breakTheGlassExpiration;
    }

    public ApplicationMode getApplicationMode() {
        return applicationMode;
    }

    public String getPatientIdentifier() {
        return patientIdentifier;
    }

    public LocalDateTime getBreakTheGlassExpiration() {
        return breakTheGlassExpiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final SessionContext sessionContext = (SessionContext) o;
        return Objects.equals(this.patientIdentifier, sessionContext.patientIdentifier) &&
                Objects.equals(this.applicationMode, sessionContext.applicationMode) &&
                Objects.equals(this.breakTheGlassExpiration, sessionContext.breakTheGlassExpiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientIdentifier, applicationMode, breakTheGlassExpiration);
    }

    public static final class SessionContextBuilder {
        private String patientIdentifier;
        private ApplicationMode applicationMode;
        private LocalDateTime breakTheGlassExpiration;

        private SessionContextBuilder() {}

        public SessionContextBuilder withPatientIdentifier(final String patientIdentifier) {
            this.patientIdentifier = patientIdentifier;
            return this;
        }

        public SessionContextBuilder withApplicationMode(final ApplicationMode applicationMode) {
            this.applicationMode = applicationMode;
            return this;
        }


        public SessionContextBuilder withBreakTheGlassExpiration(final LocalDateTime breakTheGlassExpiration) {
            this.breakTheGlassExpiration = breakTheGlassExpiration;
            return this;
        }

        public SessionContext build() {
            return new SessionContext(patientIdentifier, applicationMode, breakTheGlassExpiration);
        }
    }
}
