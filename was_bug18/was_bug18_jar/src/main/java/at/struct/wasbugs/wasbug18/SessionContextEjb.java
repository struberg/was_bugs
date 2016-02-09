package at.struct.wasbugs.wasbug18;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class SessionContextEjb {
    private String state;

    private @Resource SessionContext sessionContext;

    @PostConstruct
    public void init() {
        state = "OK";
    }

    public String getState() {
        return state;
    }

    public SessionContext getSessionContext() {
        return sessionContext;
    }
}
