package at.ac.tuwien.swa.service;

import javax.jws.WebService;

import at.ac.tuwien.swa.service.dto.PeerInformation;

@WebService(name = "ServerService", targetNamespace = "http://ServerService.service.swa.tuwien.ac.at/")
public interface ServerService {

	public String registerPeer(PeerInformation peerInformation);

	public String connectPeer(PeerInformation peerInformation);

	public String disconnectPeer(PeerInformation peerInformation);

	public PeerInformation getRelayPeer();

	public PeerInformation getRandomPeer();
}
