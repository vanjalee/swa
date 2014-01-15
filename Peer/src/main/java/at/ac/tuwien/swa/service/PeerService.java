package at.ac.tuwien.swa.service;

import javax.jws.WebService;

import at.ac.tuwien.swa.service.dto.AnalysisResult;
import at.ac.tuwien.swa.service.dto.PeerInformation;

@WebService(name = "PeerService", targetNamespace = "http://PeerService.service.swa.tuwien.ac.at/")
public interface PeerService {

	public AnalysisResult checkFingerprint(PeerInformation peerInformation, String fingerprintMessage);
	
}
