package at.struct.wasbug22;

import at.struct.wasbug22.interceptor.EjbTimer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

@EjbTimer
@Startup
@Singleton
@Lock(LockType.WRITE)
public class ScheduledEjb {

    private static final Logger LOG = Logger.getLogger(ScheduledEjb.class.getSimpleName());
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    private @Resource TimerService timerService;

    @PostConstruct
    public void initTimer() {
        // we need to start the actual scheduling only after waiting a bit
        // as WAS might not be properly boot yet - CDI might not yet be fully available.
        timerService.createSingleActionTimer(3000L, new TimerConfig("ScheduledEJB", false));
    }

    @Timeout
    public void timeout() {
        LOG.log(Level.INFO, "running! {0}", new Object[]{FORMATTER.format(Calendar.getInstance().getTime())});
        timerService.createSingleActionTimer(1000L, new TimerConfig("ScheduledEJB", false));
    }
}
