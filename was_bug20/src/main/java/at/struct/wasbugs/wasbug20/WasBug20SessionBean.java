package at.struct.wasbugs.wasbug20;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class WasBug20SessionBean implements Serializable {

    private @Inject WasBug20ApplicationService service;

    @PostConstruct
    public void initialize() {
        System.out.println("session created");
    }

    @PreDestroy
    public void sessionDestroyed() {
        System.out.println("session destroying");
        service.doSomething();
    }
}
