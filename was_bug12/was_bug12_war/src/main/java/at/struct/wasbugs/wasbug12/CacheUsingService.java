package at.struct.wasbugs.wasbug12;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CacheUsingService {

    private volatile SimpleCache cache;
    private volatile int reloads;



    public CacheInfo getCacheInfo() {
        return new CacheInfo(cache.getLastUpdate(), reloads);
    }


    void setCache(SimpleCache cache) {
        reloads++;
        this.cache = cache;
    }

}
