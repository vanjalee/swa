package at.ac.tuwien.swa.service.dto;

import java.io.Serializable;

public class AnalysisResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean matched;
	private String artist;
	private String title;	
	
	public AnalysisResult() {
	}
	public AnalysisResult(String artist, String title, boolean matched) {
		this.artist = artist;
		this.title = title;
		this.matched = matched;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	
	
	
}
