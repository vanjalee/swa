package at.ac.tuwien.swa.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.google.gson.Gson;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;
import at.ac.tuwien.swa.control.communication.ConnectionManager;
import at.ac.tuwien.swa.control.library.Library;
import at.ac.tuwien.swa.service.PeerService;
import at.ac.tuwien.swa.service.dto.AnalysisResult;
import at.ac.tuwien.swa.service.dto.PeerInformation;

@WebService(endpointInterface = "at.ac.tuwien.swa.service.PeerService", targetNamespace = "http://PeerService.service.swa.tuwien.ac.at/")
public class PeerServiceImpl implements PeerService {

	private Library library;
	private ConnectionManager connectionManager;

	public PeerServiceImpl() {
	}

	@WebMethod
	@Override
	public AnalysisResult checkFingerprint(PeerInformation peerInformation,
			String fingerprintMessage) {
		Fingerprint fingerprint = new Gson().fromJson(fingerprintMessage,
				Fingerprint.class);
		AnalysisResult analysisResult = library.match(fingerprint);
		if (!connectionManager.getPeers().contains(peerInformation)) {
			connectionManager.savePeerInformation(peerInformation);
		}
		return analysisResult;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

}
