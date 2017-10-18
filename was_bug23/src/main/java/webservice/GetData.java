
package webservice;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import at.struct.wasbug23.DateAdater;
import org.joda.time.LocalDate;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zugriffstag_yyyy-mm-dd" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zugriffstag"
})
@XmlRootElement(name = "getData")
public class GetData
    implements Serializable
{

    @XmlElement(name = "zugriffstag", required = true, type = String.class)
    @XmlJavaTypeAdapter(DateAdater.class)
    @XmlSchemaType(name = "date")
    protected LocalDate zugriffstag;

    /**
     * Ruft den Wert der zugriffstagYyyyMmDd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getZugriffstagYyyyMmDd() {
        return zugriffstag;
    }

    /**
     * Legt den Wert der zugriffstagYyyyMmDd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZugriffstagYyyyMmDd(LocalDate value) {
        this.zugriffstag = value;
    }

}
