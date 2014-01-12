
package at.ac.tuwien.swa.service.peerservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.ac.tuwien.swa.service.peerservice package. 
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

    private final static QName _CheckFingerprint_QNAME = new QName("http://PeerService.service.swa.tuwien.ac.at/", "checkFingerprint");
    private final static QName _CheckFingerprintResponse_QNAME = new QName("http://PeerService.service.swa.tuwien.ac.at/", "checkFingerprintResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.ac.tuwien.swa.service.peerservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckFingerprintResponse }
     * 
     */
    public CheckFingerprintResponse createCheckFingerprintResponse() {
        return new CheckFingerprintResponse();
    }

    /**
     * Create an instance of {@link CheckFingerprint }
     * 
     */
    public CheckFingerprint createCheckFingerprint() {
        return new CheckFingerprint();
    }

    /**
     * Create an instance of {@link AnalysisResult }
     * 
     */
    public AnalysisResult createAnalysisResult() {
        return new AnalysisResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckFingerprint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PeerService.service.swa.tuwien.ac.at/", name = "checkFingerprint")
    public JAXBElement<CheckFingerprint> createCheckFingerprint(CheckFingerprint value) {
        return new JAXBElement<CheckFingerprint>(_CheckFingerprint_QNAME, CheckFingerprint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckFingerprintResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PeerService.service.swa.tuwien.ac.at/", name = "checkFingerprintResponse")
    public JAXBElement<CheckFingerprintResponse> createCheckFingerprintResponse(CheckFingerprintResponse value) {
        return new JAXBElement<CheckFingerprintResponse>(_CheckFingerprintResponse_QNAME, CheckFingerprintResponse.class, null, value);
    }

}
