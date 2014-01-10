package at.ac.tuwien.swa.library.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "songs")
public class Songs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "song", type = Song.class)
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
