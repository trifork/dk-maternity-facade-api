package dk.sds.nsp.maternity.facade.common.jaxrs;

import javax.ws.rs.HttpMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * For some god-forsaken reason the bundled version of jax-rs does not come with a patch
 * - luckily it's trivial to make our own
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod("PATCH")
public @interface PATCH {}
