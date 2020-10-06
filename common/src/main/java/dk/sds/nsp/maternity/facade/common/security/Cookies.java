package dk.sds.nsp.maternity.facade.common.security;

import javax.ws.rs.core.NewCookie;
import java.util.Date;

public final class Cookies {

    private Cookies() {}

    public static CookieBuilder cookie() {
        return new CookieBuilder();
    }

    public static final class CookieBuilder {
        private String name;
        private String value;
        private String path;
        private String domain;
        private int version = NewCookie.DEFAULT_VERSION;
        private String comment;
        private int maxAge = NewCookie.DEFAULT_MAX_AGE;
        private Date expiry;
        private boolean secure;
        private boolean httpOnly;

        private CookieBuilder() { }

        public CookieBuilder withName(final String name) {
            this.name = name;
            return this;
        }

        public CookieBuilder withValue(final String value) {
            this.value = value;
            return this;
        }

        public CookieBuilder withPath(final String path) {
            this.path = path;
            return this;
        }

        public CookieBuilder withDomain(final String domain) {
            this.domain = domain;
            return this;
        }

        public CookieBuilder withVersion(final int version) {
            this.version = version;
            return this;
        }

        public CookieBuilder withComment(final String comment) {
            this.comment = comment;
            return this;
        }

        public CookieBuilder withMaxAge(final int maxAge) {
            this.maxAge = maxAge;
            return this;
        }

        public CookieBuilder withExpiry(final Date expiry) {
            this.expiry = expiry;
            return this;
        }

        public CookieBuilder secure() {
            secure = true;
            return this;
        }

        public CookieBuilder withSecure(final boolean secure) {
            this.secure = secure;
            return this;
        }

        public CookieBuilder httpOnly() {
            httpOnly = true;
            return this;
        }

        public CookieBuilder withHttpOnly(final boolean httpOnly) {
            this.httpOnly = httpOnly;
            return this;
        }

        public NewCookie build() {
            return new NewCookie(
                    name,
                    value,
                    path,
                    domain,
                    version,
                    comment,
                    maxAge,
                    expiry,
                    secure,
                    httpOnly);
        }
    }
}
