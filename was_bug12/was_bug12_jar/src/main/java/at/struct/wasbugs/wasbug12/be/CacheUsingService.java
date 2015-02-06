package at.struct.wasbugs.wasbug12.be;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class CacheUsingService {

    private static final Logger log = Logger.getLogger(CacheUsingService.class.getName());


    private volatile SimpleCache cache;
    private volatile int reloads;



    public CacheInfo getCacheInfo() {
        log();
        return new CacheInfo(cache.getLastUpdate(), reloads);
    }


    void setCache(SimpleCache cache) {
        log();

        reloads++;
        this.cache = cache;
    }


    private void log() {
        log.log(Level.INFO, "current thread: {0} - value of reloads: {1}", new Object[] {Thread.currentThread().getName(), reloads});
    }
}
