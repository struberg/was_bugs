package at.struct.wasbugs.wasbug15.remote;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN) // this lets WAS blow up and trash the connection
public class RemoteConnectorImpl implements RemoteConnector {
    private final static Logger LOGGER = Logger.getLogger(RemoteConnectorImpl.class.toString());

    public @Inject TestService testService;

    @Override
    public String testConn() throws Exception {

        LOGGER.info("EJB remote Service");
        return "blub " + testService.test();
    }
}
