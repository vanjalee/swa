package at.ac.tuwien.swa;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import at.ac.tuwien.swa.control.communication.PeerFactory;
import at.ac.tuwien.swa.control.library.Library;
import at.ac.tuwien.swa.control.library.impl.LibraryImpl;
import at.ac.tuwien.swa.service.dto.PeerInformation;
import at.ac.tuwien.swa.util.PeerType;

public class Peer {

	private final static Logger logger = Logger.getLogger(Peer.class.getName());
	private static PeerType peerType;
	private static Integer port;
	private static String serverWsdl;
	private static String libraryPath;	
	private static String username;
	private static String password;
	private static PeerInformation peerInformation;
	
	public static void main(String[] args) {
		String runCommandError = "Please run your peer with following arguments\n"
				+ "<path> for song library\n"
				+ "<wsdl> location of the server (super peer) sevice\n"
				+ "<port> fpr this peer to run on\n"
				+ "<peerType> EDGE | RELAY | SUPER peer type\n"
				+ "<username> peer username\n" + "<password> peer password";
		if (args.length < 6) {
			logger.log(Level.SEVERE, runCommandError);
			return;
		}

		libraryPath = args[0];
		serverWsdl = args[1];
		port = null;
		peerType = null;
		username = args[4];
		password = args[5];
		try {
			port = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE,
					"Invalid port format: Port argument must be a number...\n"
							+ runCommandError);
			return;
		}
		try {
			peerType = PeerType.valueOf(args[3]);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Invalid peer type argument.\n"
					+ runCommandError);
			return;
		}

		if (libraryPath.isEmpty()) {
			logger.log(Level.SEVERE, "Missing library path...\n"
					+ runCommandError);
			return;
		}
		if (!new File(libraryPath).exists()) {
			logger.log(Level.SEVERE, "Invalid library path..." + libraryPath
					+ "\n" + runCommandError);
			return;
		}
		if (serverWsdl.isEmpty()) {
			logger.log(Level.SEVERE, "Missing server wsdl url...\n"
					+ runCommandError);
			return;
		}
		if (port % 8079 == 0) {
			logger.log(Level.SEVERE,
					"Port argument value must be lagrer than 8080...\n"
							+ runCommandError);
			return;
		}
		if (username.isEmpty()) {
			logger.log(Level.SEVERE, "Missing username...\n"
					+ runCommandError);
			return;
		}
		if (password.isEmpty()) {
			logger.log(Level.SEVERE, "Missing password...\n"
					+ runCommandError);
			return;
		}
		peerInformation = new PeerInformation(peerType, port, serverWsdl,
				libraryPath, username, password);
		Peer mainThread = PeerFactory.initializePeer(peerInformation);
		mainThread.run();
	}

	public void run() {
		Library controller = new LibraryImpl(libraryPath);
		controller.loadLibrary();
		controller.printSongs();
		hitEnterToStop();
	}

	private void hitEnterToStop() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press enter to exit");
			String s = null;
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (s.length() == 0) {
				System.out.println("Exiting...");
				System.exit(0);
			}
		}
	}

	public static Logger getLogger() {
		return logger;
	}

	public static PeerType getPeerType() {
		return peerType;
	}

	public static void setPeerType(PeerType peerType) {
		Peer.peerType = peerType;
	}

	public static Integer getPort() {
		return port;
	}

	public static void setPort(Integer port) {
		Peer.port = port;
	}

	public static String getServerWsdl() {
		return serverWsdl;
	}

	public static void setServerWsdl(String serverWsdl) {
		Peer.serverWsdl = serverWsdl;
	}

	public static String getLibraryPath() {
		return libraryPath;
	}

	public static void setLibraryPath(String libraryPath) {
		Peer.libraryPath = libraryPath;
	}

	public static PeerInformation getPeerInformation() {
		return peerInformation;
	}

	public static void setPeerInformation(PeerInformation peerInformation) {
		Peer.peerInformation = peerInformation;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Peer.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Peer.password = password;
	}

}
