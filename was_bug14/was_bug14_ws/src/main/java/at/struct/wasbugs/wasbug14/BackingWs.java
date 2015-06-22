package at.struct.wasbugs.wasbug14;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService(portName = "BackingWsPort", serviceName = "BackingWs", targetNamespace = "at.struct.wasbugs.wasbug14")
public class BackingWs {
    private @Inject ServiceInterface service;

    @WebMethod
    public int getMeaningOfLife() {
        return service.meaningOfLife();
    }

}
