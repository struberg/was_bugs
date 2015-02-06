package at.struct.wasbugs.wasbug12;

import java.util.Date;

public class CacheInfo {

    private final Date lastUpdate;
    private final int reloads;


    public CacheInfo(Date lastUpdate, int reloads) {
        this.lastUpdate = lastUpdate;
        this.reloads = reloads;
    }


    public Date getLastUpdate() {
        return lastUpdate;
    }

    public int getReloads() {
        return reloads;
    }
}
