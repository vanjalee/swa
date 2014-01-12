package at.ac.tuwien.swa.control.library.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Songs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Song> songs = new ArrayList<Song>();

	public Songs() {
		super();
	}

	public Songs(List<Song> songs) {
		super();
		this.songs = songs;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
