
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.domain._private.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DataDTO_QNAME = new QName("http://private.domain.at/Webservice/", "DataDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.domain._private.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetData }
     * 
     */
    public GetData createGetData() {
        return new GetData();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link GetDataDTO }
     * 
     */
    public GetDataDTO createGetDataDTO() {
        return new GetDataDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://private.domain.at/Webservice/", name = "DataDTO")
    public JAXBElement<GetDataDTO> createDataDTO(GetDataDTO value) {
        return new JAXBElement<GetDataDTO>(_DataDTO_QNAME, GetDataDTO.class, null, value);
    }

}
