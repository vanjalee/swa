package at.ac.tuwien.swa;

import at.ac.tuwien.swa.Peer;

public class TestMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testExport();
		// SharedLibraryWatcher sharedLibraryWatcher = new
		// SharedLibraryWatcher();
		// sharedLibraryWatcher.generateFingertips();

		// sharedLibraryWatcher.runWatcher();
		Peer mainThread = new Peer();
		mainThread.run(args[0]);
	}

	/*
	 * private static void testExport() { try {
	 * 
	 * Songs songs = LibraryController.getInstance().getSongs(); File file = new
	 * File("songs.xml"); JAXBContext jaxbContext = JAXBContext
	 * .newInstance(Songs.class); Marshaller jaxbMarshaller =
	 * jaxbContext.createMarshaller(); // output pretty printed
	 * jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 * jaxbMarshaller.marshal(songs, file); } catch (JAXBException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}
