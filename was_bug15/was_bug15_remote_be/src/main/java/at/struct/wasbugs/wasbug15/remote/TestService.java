package at.struct.wasbugs.wasbug15.remote;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

/**
 * Created by 02uj0l0g on 13.10.2015.
 */
@ApplicationScoped
public class TestService  {
    private final static Logger LOGGER = Logger.getLogger(TestService.class.toString());

    @PostConstruct
    public void init() {
        LOGGER.info("Dummy TestService wurde initialisiert");
    }

    public String test(){
        return "testServiceImpl";
    }

}
