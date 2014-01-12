package at.ac.tuwien.swa.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.ac.tuwien.swa.service.PeerService;
import at.ac.tuwien.swa.service.dto.AnalysisResult;

@WebService(endpointInterface="at.ac.tuwien.swa.service.PeerService", targetNamespace="http://PeerService.service.swa.tuwien.ac.at/")
public class PeerServiceImpl implements PeerService {

	public PeerServiceImpl() {
	}

	@WebMethod
	@Override
	public AnalysisResult checkFingerprint(String fingerprintMessage) {
		
		
		
		return new AnalysisResult();
	}

}
