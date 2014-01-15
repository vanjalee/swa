package at.ac.tuwien.swa.service.dto;

import java.io.Serializable;

import at.ac.tuwien.swa.util.PeerType;

public class PeerInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PeerType peerType;
	private Integer port;
	private String serverWsdl;
	private String localWsdl;
	private String libraryPath;
	private String username;
	private String password;

	public PeerInformation() {
	}

	public PeerInformation(PeerType peerType, Integer port, String serverWsdl,
			String localWsdl, String libraryPath, String username,
			String password) {
		this.peerType = peerType;
		this.port = port;
		this.serverWsdl = serverWsdl;
		this.libraryPath = libraryPath;
		this.username = username;
		this.password = password;
	}

	public PeerType getPeerType() {
		return peerType;
	}

	public void setPeerType(PeerType peerType) {
		this.peerType = peerType;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getServerWsdl() {
		return serverWsdl;
	}

	public void setServerWsdl(String serverWsdl) {
		this.serverWsdl = serverWsdl;
	}

	public String getLibraryPath() {
		return libraryPath;
	}

	public void setLibraryPath(String libraryPath) {
		this.libraryPath = libraryPath;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocalWsdl() {
		return localWsdl;
	}

	public void setLocalWsdl(String localWsdl) {
		this.localWsdl = localWsdl;
	}

}
