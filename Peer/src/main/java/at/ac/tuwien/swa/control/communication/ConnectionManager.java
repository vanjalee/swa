package at.ac.tuwien.swa.control.communication;

import java.util.List;

import at.ac.tuwien.swa.service.dto.PeerInformation;

public interface ConnectionManager {

	PeerInformation getServerPeerInformation();

	void setServerPeerInformation(PeerInformation serverPeerInformation);

	PeerInformation getLocalPeerInformation();

	void setLocalPeerInformation(PeerInformation localPeerInformation);

	void initializeNodePeersList();

	void savePeerInformation(PeerInformation peerInformation);

	List<PeerInformation> getRelayPeers();

	List<PeerInformation> getPeers();
	
	void initializePeerInformation();

}
