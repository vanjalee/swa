package at.ac.tuwien.swa.control.library.dto;

import java.io.File;
import java.io.Serializable;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;

public class Song implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String artist;
	private String songFileName;
	private File songFile;
	private Fingerprint fingerprint;
	private boolean matched;

	public Song() {
	}

	public Song(String songFileName, Fingerprint fingerprint, File songFile) {
		this.songFileName = songFileName;
		this.fingerprint = fingerprint;
		this.songFile = songFile;
	}

	public Song(String artist, String title, String songFileName,
			Fingerprint fingerprint, File songFile) {
		this.title = title;
		this.artist = artist;
		this.songFileName = songFileName;
		this.fingerprint = fingerprint;
		this.songFile = songFile;
	}

	public Song(String artist, String title, String songFileName,
			Fingerprint fingerprint, boolean matched, File songFile) {
		this.title = title;
		this.artist = artist;
		this.songFileName = songFileName;
		this.fingerprint = fingerprint;
		this.songFile = songFile;
		this.matched = matched;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongFileName() {
		return songFileName;
	}

	public void setSongFileName(String songFileName) {
		this.songFileName = songFileName;
	}

	public Fingerprint getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(Fingerprint fingerprint) {
		this.fingerprint = fingerprint;
	}

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	public File getSongFile() {
		return songFile;
	}

	public void setSongFile(File songFile) {
		this.songFile = songFile;
	}

}
