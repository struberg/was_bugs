package at.struct.wasbugs.wasbug15.remote;

import javax.ejb.Remote;

@Remote
public interface RemoteConnector {

    public String testConn() throws Exception;
}
