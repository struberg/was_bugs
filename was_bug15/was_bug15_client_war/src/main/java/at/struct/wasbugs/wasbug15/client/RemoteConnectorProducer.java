package at.struct.wasbugs.wasbug15.client;

import at.struct.wasbugs.wasbug15.remote.RemoteConnector;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.text.MessageFormat;

/**
 * Actually not needed for EJB, but in the real app we do some logic in this class.
 * @author Philipp Marschall
 */
public class RemoteConnectorProducer {
    private final static Logger LOGGER = Logger.getLogger(RemoteConnectorProducer.class.toString());

    @EJB(lookup = "at.struct.wasbugs.wasbug15.remote.RemoteConnector")
    private RemoteConnector remoteConnector;

    @Produces
    @ApplicationScoped
    public RemoteConnector create() {
        LOGGER.info("Create RemoteConnector");
        if (remoteConnector == null) {
            throw new IllegalStateException(MessageFormat.format("Can not find implementation of interface {0} - Please check deployment", RemoteConnector.class.getName()));
        }
        return remoteConnector;
    }

}
