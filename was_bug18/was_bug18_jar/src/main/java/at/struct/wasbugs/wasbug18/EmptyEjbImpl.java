package at.struct.wasbugs.wasbug18;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class EmptyEjbImpl implements EmptyEjb {
    private String state;

    @PostConstruct
    public void init() {
        state = "OK";
    }

    @Override
    public String getState() {
        return state;
    }
}
