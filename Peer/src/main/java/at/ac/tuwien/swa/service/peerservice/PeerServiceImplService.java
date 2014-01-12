
package at.ac.tuwien.swa.service.peerservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PeerServiceImplService", targetNamespace = "http://PeerService.service.swa.tuwien.ac.at/", wsdlLocation = "http://localhost:8080/peer/peerService?wsdl")
public class PeerServiceImplService
    extends Service
{

    private final static URL PEERSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException PEERSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName PEERSERVICEIMPLSERVICE_QNAME = new QName("http://PeerService.service.swa.tuwien.ac.at/", "PeerServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/peer/peerService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PEERSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        PEERSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public PeerServiceImplService() {
        super(__getWsdlLocation(), PEERSERVICEIMPLSERVICE_QNAME);
    }

    public PeerServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PEERSERVICEIMPLSERVICE_QNAME);
    }

    public PeerServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, PEERSERVICEIMPLSERVICE_QNAME);
    }

    public PeerServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PEERSERVICEIMPLSERVICE_QNAME);
    }

    public PeerServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PeerServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns PeerService
     */
    @WebEndpoint(name = "PeerServiceImplPort")
    public PeerService getPeerServiceImplPort() {
        return super.getPort(new QName("http://PeerService.service.swa.tuwien.ac.at/", "PeerServiceImplPort"), PeerService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PeerService
     */
    @WebEndpoint(name = "PeerServiceImplPort")
    public PeerService getPeerServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://PeerService.service.swa.tuwien.ac.at/", "PeerServiceImplPort"), PeerService.class);
    }

    private static URL __getWsdlLocation() {
        if (PEERSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw PEERSERVICEIMPLSERVICE_EXCEPTION;
        }
        return PEERSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
