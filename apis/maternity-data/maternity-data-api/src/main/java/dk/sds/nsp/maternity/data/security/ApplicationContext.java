package dk.sds.nsp.maternity.data.security;

import dk.sds.nsp.maternity.facade.common.model.ApplicationMode;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * ApplicationContextPayload
 */
@SuppressWarnings("unused")
public class ApplicationContext {
    public static final String APPLICATION_MODE_CLAIM_NAME = "applicationMode";
    public static final String BREAK_THE_GLASS_EXPIRATION_CLAIM_NAME = "breakTheGlassExpiration";

    public static ApplicationContextBuilder clone(final ApplicationContext context) { return new ApplicationContextBuilder(context); }
    public static ApplicationContextBuilder withApplicationMode(final ApplicationMode applicationMode) { return new ApplicationContextBuilder().withApplicationMode(applicationMode); }
    public static ApplicationContextBuilder withBreakTheGlassExpiration(final LocalDateTime breakTheGlassExpiration) { return new ApplicationContextBuilder().withBreakTheGlassExpiration(breakTheGlassExpiration); }

    private final ApplicationMode applicationMode;
    private final LocalDateTime breakTheGlassExpiration;

    private ApplicationContext(ApplicationMode applicationMode, LocalDateTime breakTheGlassExpiration) {
        this.applicationMode = applicationMode;
        this.breakTheGlassExpiration = breakTheGlassExpiration;
    }

    public ApplicationMode getApplicationMode() {
        return applicationMode;
    }

    public LocalDateTime getBreakTheGlassExpiration() {
        return breakTheGlassExpiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ApplicationContext applicationContext = (ApplicationContext) o;
        return Objects.equals(this.applicationMode, applicationContext.applicationMode) &&
                Objects.equals(this.breakTheGlassExpiration, applicationContext.breakTheGlassExpiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationMode, breakTheGlassExpiration);
    }

    public static final class ApplicationContextBuilder {
        private String patientIdentifier;
        private ApplicationMode applicationMode;
        private LocalDateTime breakTheGlassExpiration;

        private ApplicationContextBuilder() {}

        public ApplicationContextBuilder(final ApplicationContext context) {
            applicationMode = context.applicationMode;
            breakTheGlassExpiration = context.breakTheGlassExpiration;
        }

        public ApplicationContextBuilder withPatientIdentifier(final String patientIdentifier) {
            this.patientIdentifier = patientIdentifier;
            return this;
        }

        public ApplicationContextBuilder withApplicationMode(final ApplicationMode applicationMode) {
            this.applicationMode = applicationMode;
            return this;
        }


        public ApplicationContextBuilder withBreakTheGlassExpiration(final LocalDateTime breakTheGlassExpiration) {
            this.breakTheGlassExpiration = breakTheGlassExpiration;
            return this;
        }

        public ApplicationContext build() {
            return new ApplicationContext(applicationMode, breakTheGlassExpiration);
        }
    }
}
