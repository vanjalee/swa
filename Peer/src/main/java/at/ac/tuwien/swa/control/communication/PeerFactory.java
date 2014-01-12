package at.ac.tuwien.swa.control.communication;

import at.ac.tuwien.swa.Peer;
import at.ac.tuwien.swa.service.dto.PeerInformation;
import at.ac.tuwien.swa.util.PeerType;

public class PeerFactory {

	public static Peer initializePeer(PeerInformation peerInformation) {
		
		if (peerInformation.getPeerType().equals(PeerType.EDGE)) {
			
		} else if (peerInformation.getPeerType().equals(PeerType.RELAY)) {
			
		} else if (peerInformation.getPeerType().equals(PeerType.SUPER)) {
			
		}
		
		return new Peer();
	}
	
}
