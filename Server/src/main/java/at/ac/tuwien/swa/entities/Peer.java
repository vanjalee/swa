package at.ac.tuwien.swa.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "peer")
@Table
public class Peer extends AbstractEntity {

	public Peer() {

	}

	public Peer(Long id) {
		super(id);

	}

	private String uuid;
	private boolean online;
	private String ipAddress;

	@ManyToOne
	private User user;

	public Peer(String uuid, boolean online) {
		super();
		this.uuid = uuid;
		this.online = online;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isOnline() {
		return online;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

}
