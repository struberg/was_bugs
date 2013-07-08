package at.struct.wasbugs.wasbug5.security;

import org.apache.deltaspike.security.api.authorization.SecurityBindingType;

import javax.enterprise.util.Nonbinding;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Used for annotation-driven declarative permission checks.
 * <p/>
 * Example:
 * <pre>
 *     &#064;PermissionRequired("create")
 *     public void doSomeThing() {
 * </pre>
 * It can be declared on methods as well as on types.
 * Permissions defined at method level take precedence over those defined at type level.
 * <p/>
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Documented
@SecurityBindingType
public @interface PermissionRequired {

    /**
     * List of permissions. Execution should be permitted if the user has <em>any</em> of these permissions.
     *
     * @return  the list of permissions
     */
    @Nonbinding
    String[] value();
}
