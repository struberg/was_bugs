package at.struct.wasbugs.wasbug5.security;

import org.apache.deltaspike.security.api.authorization.Secures;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.InvocationContext;

/**
 * Backing of declarative permission checks using {@link PermissionRequired}.
 * <p/>
 * Evaluates {@link PermissionRequired#value()} and
 *
 * @see PermissionRequired
 */
@ApplicationScoped
public class PermissionRequiredAuthorizer {

    /**
     * Perform the actual security check.
     *
     * @return  <tt>true</tt> if the call is authorized, <tt>false</tt> otherwise.
     */
    @Secures
    @PermissionRequired({})
    public boolean doSecuredCheck(InvocationContext invocationContext) {
        // check annotation on method
        PermissionRequired ann = invocationContext.getMethod().getAnnotation(PermissionRequired.class);

        // check annotation on type
        if (ann == null) {
            ann = invocationContext.getMethod().getDeclaringClass().getAnnotation(PermissionRequired.class);
        }

        // safe guard: if no annotation is present, this method should not even be called
        if (ann == null) {
            return false;
        }

        final String[] value = ann.value();

        if (value.length == 0) {
            return false;
        }

        // this is just a fake hack. In real apps there would be a call to an AuthorisationService or similar.
        return "ok".equals(value);
    }
}
