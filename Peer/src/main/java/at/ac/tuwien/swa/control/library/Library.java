package at.ac.tuwien.swa.control.library;

import java.io.File;

import at.ac.tuwien.swa.control.library.dto.Song;
import at.ac.tuwien.swa.control.library.dto.Songs;

public interface Library {

	public abstract void loadLibrary();

	public abstract void addSong(Song song);

	public abstract void generateFingerPrint(File file);

	public abstract Song match(Song song);

	public abstract Songs getSongs();

	public abstract void printSongs();

}