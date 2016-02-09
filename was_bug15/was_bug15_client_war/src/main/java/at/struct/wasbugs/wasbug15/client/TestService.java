package at.struct.wasbugs.wasbug15.client;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by 02uj0l0g on 05.10.2015.
 */
@ApplicationScoped
public class TestService {
    private final static Logger LOGGER = Logger.getLogger(TestService.class.toString());
    private @Inject InjectTest injectTest;

    public String testwrite() {
        LOGGER.info("Inject Level 1");
        return "Level 1 ->"+injectTest.testwrite();
    }
}
