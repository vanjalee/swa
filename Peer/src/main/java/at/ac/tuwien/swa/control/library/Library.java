package at.ac.tuwien.swa.control.library;

import java.io.File;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;
import at.ac.tuwien.swa.control.library.dto.Song;
import at.ac.tuwien.swa.control.library.dto.Songs;
import at.ac.tuwien.swa.service.dto.AnalysisResult;

public interface Library {

	public void loadLibrary();

	public void addSong(Song song);

	public void generateFingerPrint(File file);

	public Song match(Song song);

	public Songs getSongs();

	public void printSongs();

	public AnalysisResult match(Fingerprint fingerprint);

}