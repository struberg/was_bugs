package at.struct.wasbugs.wasbug18;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Wrapper to 'break' EJB injection cycle.
 */
@ApplicationScoped
public class EjbHolder {
    private @Inject EmptyEjb cdiInjectedEmptyEjb;
    private @EJB    EmptyEjb ejbInjectedEmptyEjb;

    private @Inject SessionContextEjb cdiInjectedSessionContextEjb;
    private @EJB    SessionContextEjb ejbInjectedSessionContextEjb;



    public EmptyEjb getCdiInjectedEmptyEjb() {
        return cdiInjectedEmptyEjb;
    }

    public EmptyEjb getEjbInjectedEmptyEjb() {
        return ejbInjectedEmptyEjb;
    }

    public SessionContextEjb getCdiInjectedSessionContextEjb() {
        return cdiInjectedSessionContextEjb;
    }

    public SessionContextEjb getEjbInjectedSessionContextEjb() {
        return ejbInjectedSessionContextEjb;
    }
}
