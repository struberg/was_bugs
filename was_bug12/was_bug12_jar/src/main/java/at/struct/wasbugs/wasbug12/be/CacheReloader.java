package at.struct.wasbugs.wasbug12.be;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
@Lock(value = LockType.WRITE)
public class CacheReloader {

    private static final Logger log = Logger.getLogger(CacheReloader.class.getName());


    private @Inject CacheUsingService service;


    @PostConstruct
    protected void init() {
        reload();
    }


    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void reload() {
        log.log(Level.INFO, "Reloading Cache");

        // know lets do some heavy work
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            // bad luck
            log.log(Level.WARNING, "Thread {0} interrupted", Thread.currentThread().getName());
        }

        service.setCache(new SimpleCache(new Date()));

        log.log(Level.INFO, "Reloaded Cache");
    }
}
