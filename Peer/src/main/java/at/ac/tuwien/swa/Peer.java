package at.ac.tuwien.swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import at.ac.tuwien.swa.library.LibraryController;

public class Peer {

	private final static Logger logger = Logger.getLogger(Peer.class
			.getName());

	public static void main(String[] args) {
		
		System.out.println(args[0]);
		
		Peer mainThread = new Peer();
		mainThread.run(args[0]);
	}

	
	public void run(String libraryPath) {
		LibraryController controller = new LibraryController(libraryPath);
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

}
