
package at.ac.tuwien.swa.service.serverservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.ac.tuwien.swa.service.serverservice package. 
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

    private final static QName _GetRelayPeer_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "getRelayPeer");
    private final static QName _ConnectPeer_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "connectPeer");
    private final static QName _DisconnectPeer_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "disconnectPeer");
    private final static QName _DisconnectPeerResponse_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "disconnectPeerResponse");
    private final static QName _GetRandomPeerResponse_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "getRandomPeerResponse");
    private final static QName _GetRelayPeerResponse_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "getRelayPeerResponse");
    private final static QName _GetRandomPeer_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "getRandomPeer");
    private final static QName _ConnectPeerResponse_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "connectPeerResponse");
    private final static QName _RegisterPeer_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "registerPeer");
    private final static QName _RegisterPeerResponse_QNAME = new QName("http://ServerService.service.swa.tuwien.ac.at/", "registerPeerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.ac.tuwien.swa.service.serverservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterPeerResponse }
     * 
     */
    public RegisterPeerResponse createRegisterPeerResponse() {
        return new RegisterPeerResponse();
    }

    /**
     * Create an instance of {@link RegisterPeer }
     * 
     */
    public RegisterPeer createRegisterPeer() {
        return new RegisterPeer();
    }

    /**
     * Create an instance of {@link ConnectPeerResponse }
     * 
     */
    public ConnectPeerResponse createConnectPeerResponse() {
        return new ConnectPeerResponse();
    }

    /**
     * Create an instance of {@link GetRandomPeer }
     * 
     */
    public GetRandomPeer createGetRandomPeer() {
        return new GetRandomPeer();
    }

    /**
     * Create an instance of {@link GetRelayPeerResponse }
     * 
     */
    public GetRelayPeerResponse createGetRelayPeerResponse() {
        return new GetRelayPeerResponse();
    }

    /**
     * Create an instance of {@link GetRandomPeerResponse }
     * 
     */
    public GetRandomPeerResponse createGetRandomPeerResponse() {
        return new GetRandomPeerResponse();
    }

    /**
     * Create an instance of {@link DisconnectPeerResponse }
     * 
     */
    public DisconnectPeerResponse createDisconnectPeerResponse() {
        return new DisconnectPeerResponse();
    }

    /**
     * Create an instance of {@link DisconnectPeer }
     * 
     */
    public DisconnectPeer createDisconnectPeer() {
        return new DisconnectPeer();
    }

    /**
     * Create an instance of {@link ConnectPeer }
     * 
     */
    public ConnectPeer createConnectPeer() {
        return new ConnectPeer();
    }

    /**
     * Create an instance of {@link GetRelayPeer }
     * 
     */
    public GetRelayPeer createGetRelayPeer() {
        return new GetRelayPeer();
    }

    /**
     * Create an instance of {@link PeerInformation }
     * 
     */
    public PeerInformation createPeerInformation() {
        return new PeerInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRelayPeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "getRelayPeer")
    public JAXBElement<GetRelayPeer> createGetRelayPeer(GetRelayPeer value) {
        return new JAXBElement<GetRelayPeer>(_GetRelayPeer_QNAME, GetRelayPeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectPeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "connectPeer")
    public JAXBElement<ConnectPeer> createConnectPeer(ConnectPeer value) {
        return new JAXBElement<ConnectPeer>(_ConnectPeer_QNAME, ConnectPeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisconnectPeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "disconnectPeer")
    public JAXBElement<DisconnectPeer> createDisconnectPeer(DisconnectPeer value) {
        return new JAXBElement<DisconnectPeer>(_DisconnectPeer_QNAME, DisconnectPeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisconnectPeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "disconnectPeerResponse")
    public JAXBElement<DisconnectPeerResponse> createDisconnectPeerResponse(DisconnectPeerResponse value) {
        return new JAXBElement<DisconnectPeerResponse>(_DisconnectPeerResponse_QNAME, DisconnectPeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRandomPeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "getRandomPeerResponse")
    public JAXBElement<GetRandomPeerResponse> createGetRandomPeerResponse(GetRandomPeerResponse value) {
        return new JAXBElement<GetRandomPeerResponse>(_GetRandomPeerResponse_QNAME, GetRandomPeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRelayPeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "getRelayPeerResponse")
    public JAXBElement<GetRelayPeerResponse> createGetRelayPeerResponse(GetRelayPeerResponse value) {
        return new JAXBElement<GetRelayPeerResponse>(_GetRelayPeerResponse_QNAME, GetRelayPeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRandomPeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "getRandomPeer")
    public JAXBElement<GetRandomPeer> createGetRandomPeer(GetRandomPeer value) {
        return new JAXBElement<GetRandomPeer>(_GetRandomPeer_QNAME, GetRandomPeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectPeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "connectPeerResponse")
    public JAXBElement<ConnectPeerResponse> createConnectPeerResponse(ConnectPeerResponse value) {
        return new JAXBElement<ConnectPeerResponse>(_ConnectPeerResponse_QNAME, ConnectPeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterPeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "registerPeer")
    public JAXBElement<RegisterPeer> createRegisterPeer(RegisterPeer value) {
        return new JAXBElement<RegisterPeer>(_RegisterPeer_QNAME, RegisterPeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterPeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServerService.service.swa.tuwien.ac.at/", name = "registerPeerResponse")
    public JAXBElement<RegisterPeerResponse> createRegisterPeerResponse(RegisterPeerResponse value) {
        return new JAXBElement<RegisterPeerResponse>(_RegisterPeerResponse_QNAME, RegisterPeerResponse.class, null, value);
    }

}
