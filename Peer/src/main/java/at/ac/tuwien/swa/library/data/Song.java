package at.ac.tuwien.swa.library.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import ac.at.tuwien.infosys.swa.audio.Fingerprint;

@XmlRootElement(name = "song")
@XmlAccessorType(XmlAccessType.FIELD)
public class Song implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlElement
	private String name;
	@XmlTransient
	private Fingerprint fingerprint;

	public Song() {
	}

	public Song(String name, Fingerprint fingerprint) {
		super();
		this.fingerprint = fingerprint;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Fingerprint getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(Fingerprint fingerprint) {
		this.fingerprint = fingerprint;
	}

}
