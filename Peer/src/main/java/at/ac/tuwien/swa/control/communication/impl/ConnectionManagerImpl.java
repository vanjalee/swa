package at.ac.tuwien.swa.control.communication.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import at.ac.tuwien.swa.control.communication.ConnectionManager;
import at.ac.tuwien.swa.service.dto.PeerInformation;
import at.ac.tuwien.swa.util.PeerType;

public class ConnectionManagerImpl implements ConnectionManager {

	private List<PeerInformation> nodePeers;
	private PeerInformation serverPeerInformation;
	private PeerInformation localPeerInformation;

	public ConnectionManagerImpl() {
	}

	@PostConstruct
	@Override
	public void initializePeerInformation() {
		// http://127.0.0.1:8080/peer/peerService?wsdl
		// localPeerInformation = new PeerInformation(peerType, port,
		// serverWsdl, localWsdl, libraryPath, username, password)
	}

	@Override
	public void initializeNodePeersList() {
		this.nodePeers = new ArrayList<PeerInformation>();
	}

	@Override
	public void savePeerInformation(PeerInformation peerInformation) {
		nodePeers.add(peerInformation);
	}

	@Override
	public List<PeerInformation> getRelayPeers() {
		List<PeerInformation> relayPeers = new ArrayList<PeerInformation>();
		for (PeerInformation pi : nodePeers) {
			if (pi.getPeerType().equals(PeerType.RELAY)) {
				relayPeers.add(pi);
			}
		}
		return relayPeers;
	}

	public List<PeerInformation> getNodePeers() {
		return nodePeers;
	}

	public void setNodePeers(List<PeerInformation> nodePeers) {
		this.nodePeers = nodePeers;
	}

	@Override
	public PeerInformation getServerPeerInformation() {
		return serverPeerInformation;
	}

	@Override
	public void setServerPeerInformation(PeerInformation serverPeerInformation) {
		this.serverPeerInformation = serverPeerInformation;
	}

	@Override
	public PeerInformation getLocalPeerInformation() {
		return localPeerInformation;
	}

	@Override
	public void setLocalPeerInformation(PeerInformation localPeerInformation) {
		this.localPeerInformation = localPeerInformation;
	}

	@Override
	public List<PeerInformation> getPeers() {
		return getNodePeers();
	}
}
