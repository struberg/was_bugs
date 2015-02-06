package at.struct.wasbugs.wasbug12.be;

import java.util.Date;

public class SimpleCache {

    private final Date lastUpdate;


    public SimpleCache(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public Date getLastUpdate() {
        return new Date(lastUpdate.getTime());
    }
}
