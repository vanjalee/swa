import java.net.MalformedURLException;
import java.net.URL;

import at.ac.tuwien.swa.service.serverservice.PeerInformation;
import at.ac.tuwien.swa.service.serverservice.ServerService;
import at.ac.tuwien.swa.service.serverservice.ServerServiceImplService;

public class ServiceConnectionTest {

	private static final String wsdl = "http://localhost:8080/peer/serverService?wsdl";

	public static void main(String[] args) {

		// at.ac.tuwien.swa.service.stub.server.ObjectFactory of = new
		// at.ac.tuwien.swa.service.stub.server.ObjectFactory();
		try {
			ServerService servicePort = (ServerService) new ServerServiceImplService(
					new URL(wsdl)).getServerServiceImplPort();

			PeerInformation peerInformation = servicePort
					.getRandomPeer();
			System.out.println(peerInformation.getServerWsdl());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
