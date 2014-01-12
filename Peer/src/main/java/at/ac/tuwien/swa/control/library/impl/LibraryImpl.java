package at.ac.tuwien.swa.control.library.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.tika.Tika;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;
import ac.at.tuwien.infosys.swa.audio.FingerprintSystem;
import at.ac.tuwien.swa.control.library.Library;
import at.ac.tuwien.swa.control.library.dto.Song;
import at.ac.tuwien.swa.control.library.dto.Songs;

public class LibraryImpl implements Library {

	public LibraryImpl() {
	}

	private final static Logger logger = Logger.getLogger(LibraryImpl.class
			.getName());
	private String libraryPath;

	public LibraryImpl(String libraryPath) {
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
	private ConcurrentHashMap<String, Song> library = new ConcurrentHashMap<String, Song>();

	private Tika tika = new Tika();

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.ac.tuwien.swa.library.Library#loadLibrary()
	 */
	@Override
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

			String mediaType = tika.detect(file);
			if (mediaType.equals("audio/mpeg")) {
				// logger.log(Level.INFO, "File type: " + mediaType);
				System.out.println(file.getName());
				generateFingerPrint(file);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.ac.tuwien.swa.library.Library#addSong(at.ac.tuwien.swa.library.data
	 * .Song)
	 */
	@Override
	public void addSong(Song song) {
		getLibrary().put(song.getSongFileName(), song);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.ac.tuwien.swa.library.Library#generateFingerPrint(java.io.File)
	 */
	@Override
	public void generateFingerPrint(File file) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(file);
			Fingerprint fingerprint = FingerprintSystem
					.fingerprint(audioInputStream);
			if (!getLibrary().containsKey(file.getName())
					|| (getLibrary().containsKey(file.getName()) && !getLibrary()
							.get(file.getName()).equals(fingerprint))) {
				Song song = new Song(file.getName(), fingerprint, file);
				fillAudioInformation(song);

				addSong(song);
			}
			audioInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (CannotReadException e) {
			e.printStackTrace();
		} catch (TagException e) {
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.ac.tuwien.swa.library.Library#match(ac.at.tuwien.infosys.swa.audio
	 * .Fingerprint)
	 */
	@Override
	public Song match(Song song) {
		for (String key : library.keySet()) {
			if (song.getFingerprint().match(library.get(key).getFingerprint()) > -1) {
				song.setMatched(true);
				try {
					fillAudioInformation(song);
				} catch (CannotReadException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TagException e) {
					e.printStackTrace();
				} catch (ReadOnlyFileException e) {
					e.printStackTrace();
				} catch (InvalidAudioFrameException e) {
					e.printStackTrace();
				}
			}
		}
		return song;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.ac.tuwien.swa.library.Library#getSongs()
	 */
	@Override
	public Songs getSongs() {
		List<Song> songs = new ArrayList<Song>();
		for (String key : library.keySet()) {
			songs.add(library.get(key));
		}
		return new Songs(songs);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.ac.tuwien.swa.library.Library#printSongs()
	 */
	@Override
	public void printSongs() {
		Songs songs = getSongs();
		for (Song s : songs.getSongs()) {
			logger.info(s.getSongFileName());
		}
	}

	private Song fillAudioInformation(Song song) throws CannotReadException,
			IOException, TagException, ReadOnlyFileException,
			InvalidAudioFrameException {
		// the lib is too verbose... shut it up
		LogManager.getLogManager().reset();
		AudioFile f = AudioFileIO.read(song.getSongFile());
		Tag tag = f.getTag();
		LogManager.getLogManager().readConfiguration();	
		
		try {
			song.setArtist(tag.getFirst(FieldKey.ARTIST));
			song.setTitle(tag.getFirst(FieldKey.TITLE));
		} catch (KeyNotFoundException e) {
			fillRawInformation(song);
			logger.log(Level.WARNING, song.getSongFileName() + " : This audio file has no information attached to it. Generating raw information.");
		} catch (NullPointerException e) {
			fillRawInformation(song);
			logger.log(Level.WARNING, song.getSongFileName() + " : This audio file has no information attached to it. Generating raw information.");
		}		
		return song;
	}
	
	private void fillRawInformation(Song song) {
		String artist = null;
		String title;
		String [] split = song.getSongFileName().split(" - ");			
		if(split.length == 2) {			
			// System.out.println(split[0] + " = " + split[1]);			
			artist = split[0];
			String [] splitTitle = split[1].split("\\.");
			title = splitTitle[0];
		} else {
			String [] splitTitle = split[1].split("\\.");
			title = splitTitle[0];
		}
		song.setArtist(artist);
		song.setTitle(title);
	}

	public ConcurrentHashMap<String, Song> getLibrary() {
		return library;
	}

	public void setLibrary(ConcurrentHashMap<String, Song> library) {
		this.library = library;
	}
}
