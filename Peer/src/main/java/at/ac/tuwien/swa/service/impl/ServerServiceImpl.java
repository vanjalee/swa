/**
 * ServerServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package at.ac.tuwien.swa.service.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.ac.tuwien.swa.service.ServerService;
import at.ac.tuwien.swa.service.dto.PeerInformation;
import at.ac.tuwien.swa.service.serverservice.ServerServiceImplService;

@WebService(endpointInterface = "at.ac.tuwien.swa.service.ServerService", targetNamespace = "http://ServerService.service.swa.tuwien.ac.at/")
public class ServerServiceImpl implements ServerService {
	
	@WebMethod
	@Override
	public String registerPeer(PeerInformation peerInformation) {
		try {
			ServerService servicePort = (ServerService) new ServerServiceImplService(
					new URL(peerInformation.getServerWsdl())).getServerServiceImplPort();
			return servicePort.registerPeer(peerInformation);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "Registration failed.";
	}

	@WebMethod
	@Override
	public String connectPeer(PeerInformation peerInformation) {
		try {
			ServerService servicePort = (ServerService) new ServerServiceImplService(
					new URL(peerInformation.getServerWsdl())).getServerServiceImplPort();
			return servicePort.connectPeer(peerInformation);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "Connection failed.";
	}

	@WebMethod
	@Override
	public String disconnectPeer(PeerInformation peerInformation) {
		try {
			ServerService servicePort = (ServerService) new ServerServiceImplService(
					new URL(peerInformation.getServerWsdl())).getServerServiceImplPort();
			return servicePort.disconnectPeer(peerInformation);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "Disconnecting failed.";
	}

	@WebMethod
	@Override
	public PeerInformation getRelayPeer() {
		try {
			ServerService servicePort = (ServerService) new ServerServiceImplService(
					new URL("")).getServerServiceImplPort();
			return servicePort.getRelayPeer();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@WebMethod
	@Override
	public PeerInformation getRandomPeer() {
		try {
			ServerService servicePort = (ServerService) new ServerServiceImplService(
					new URL("")).getServerServiceImplPort();
			return servicePort.getRandomPeer();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
