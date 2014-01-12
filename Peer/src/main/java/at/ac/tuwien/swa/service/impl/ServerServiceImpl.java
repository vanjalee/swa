/**
 * ServerServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.ac.tuwien.swa.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.ac.tuwien.swa.service.ServerService;
import at.ac.tuwien.swa.service.dto.PeerInformation;
import at.ac.tuwien.swa.util.PeerType;

@WebService(endpointInterface="at.ac.tuwien.swa.service.ServerService", targetNamespace="http://ServerService.service.swa.tuwien.ac.at/")
public class ServerServiceImpl implements ServerService {

	@WebMethod
	@Override
	public String registerPeer(PeerInformation peerInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@WebMethod
	@Override
	public String connectPeer(PeerInformation peerInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@WebMethod
	@Override
	public String disconnectPeer(PeerInformation peerInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@WebMethod
	@Override
	public PeerInformation getRelayPeer() {
		// TODO Auto-generated method stub
		return null;
	}

	@WebMethod
	@Override
	public PeerInformation getRandomPeer() {
		PeerInformation peerInformation = new PeerInformation(PeerType.SUPER, 8080, "http://localhost:8080/peer/serverService?wsdl", "", "", "");
		return peerInformation;
	}

}
