package at.ac.tuwien.swa.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "session")
@Table
public class Session extends AbstractEntity {

	public Session() {

	}

	public Session(Long id) {
		super(id);

	}

	private String uuid;

	@OneToOne
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}
}
