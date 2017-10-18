package at.struct.wasbug23;

import org.joda.time.LocalDate;
import webservice.GetDataDTO;
import webservice.SampleService;

import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.Collections;
import java.util.List;

@Stateless
@WebService(endpointInterface = "webservice.SampleService",
        targetNamespace = "http://private.domain.at/Webservice/",
        serviceName = "SampleService",
        portName = "SampleServicePort")
public class SampleServiceImpl implements SampleService {

    @Override
    public List<GetDataDTO> getData(LocalDate zugriffstag) {
        return Collections.emptyList();
    }
}
