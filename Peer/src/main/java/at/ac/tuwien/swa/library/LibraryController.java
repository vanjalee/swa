package at.ac.tuwien.swa.library;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;
import ac.at.tuwien.infosys.swa.audio.FingerprintSystem;
import at.ac.tuwien.swa.library.data.Song;
import at.ac.tuwien.swa.library.data.Songs;

/*import org.apache.tika.Tika;*/

public class LibraryController {

	private final static Logger logger = Logger
			.getLogger(LibraryController.class.getName());
	private String libraryPath;

	public LibraryController(String libraryPath) {
		this.libraryPath = libraryPath;
	}

	// Why this?
	// There is no locking at the object level,The locking is at a much finer
	// granularity. For a concurrentHashMap, the locks may be at a hashmap
	// bucket level. The effect of lower level locking is that you can
	// have concurrent readers and writers whilch is not possible for
	// synchronized collections. This leads to much more scalability.
	// ConcurrentHashMap does not throw a ConcurrentModificationException
	// if one thread tries to modify it while another is iterating over it.
	private ConcurrentHashMap<String, Fingerprint> library = new ConcurrentHashMap<String, Fingerprint>();

	/* private Tika tika = new Tika(); */

	public void loadLibrary() {
		try {
			scanFolder(libraryPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void scanFolder(String path) throws IOException {
		File[] list = new File(path).listFiles();
		if (list == null)
			return;
		for (File file : list) {

			/*
			 * String mediaType = tika.detect(file); if
			 * (mediaType.equals("audio/mpeg")) {
			 */
			// logger.log(Level.INFO, "File type: " + mediaType);
			System.out.println(file.getName());
			generateFingerPrint(file);
			/* } */
		}
	}

	public void addSong(Song song) {
		getLibrary().put(song.getName(), song.getFingerprint());
	}

	public void generateFingerPrint(File file) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(file);
			Fingerprint fingerprint = FingerprintSystem
					.fingerprint(audioInputStream);
			if (!getLibrary().containsKey(file.getName())
					|| (getLibrary().containsKey(file.getName()) && !getLibrary()
							.get(file.getName()).equals(fingerprint))) {
				addSong(new Song(file.getName(), fingerprint));
			}
			audioInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}

	public Song match(Fingerprint fingerprint) {
		for (String key : library.keySet()) {
			if (fingerprint.match(library.get(key)) > -1) {
				return new Song(key, fingerprint);
			}
		}
		return null;
	}

	public Songs getSongs() {
		List<Song> songs = new ArrayList<Song>();
		for (String key : library.keySet()) {
			songs.add(new Song(key, library.get(key)));
		}
		return new Songs(songs);
	}

	public void printSongs() {
		Songs songs = getSongs();
		for (Song s : songs.getSongs()) {
			logger.info(s.getName());
		}
	}

	public ConcurrentHashMap<String, Fingerprint> getLibrary() {
		return library;
	}

	public void setLibrary(ConcurrentHashMap<String, Fingerprint> library) {
		this.library = library;
	}
}
