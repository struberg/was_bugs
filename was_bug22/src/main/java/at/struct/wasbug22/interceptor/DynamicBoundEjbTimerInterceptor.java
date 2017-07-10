package at.struct.wasbug22.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

@EjbTimer
@Interceptor
public class DynamicBoundEjbTimerInterceptor {

    private static final Logger LOG = Logger.getLogger(DynamicBoundEjbTimerInterceptor.class.getSimpleName());
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    @AroundTimeout
    public Object aroundTimeout(InvocationContext ic) throws Exception {
        LOG.log(Level.INFO, "timeout intercepted! {0}", new Object[]{FORMATTER.format(Calendar.getInstance().getTime())});
        try {
            return ic.proceed();
        } finally {
            LOG.log(Level.INFO, "timeout interception finished! {0}", new Object[]{FORMATTER.format(Calendar.getInstance().getTime())});
        }
    }

    // This method is needed by OpenEJB 1.7.4 to load and run this interceptor, even if just timeouts are intercepted. Removing this method prevents interception of timeouts.
    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws Exception {
        System.exit(1); // Nevermind, this actually never gets called.
        return ic.proceed();
    }
}
