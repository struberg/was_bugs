package at.struct.wasbugs.wasbug15.client;

import java.util.logging.Logger;

public class InjectTest {
    private final static Logger LOGGER = Logger.getLogger(InjectTest.class.toString());

    public String testwrite() {
        LOGGER.info("Inject Level 2");
        return "Level 2";
    }
}
