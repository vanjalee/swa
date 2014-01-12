package at.ac.tuwien.swa.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "coin")
@Table
public class Coin extends AbstractEntity {

	public static final int VALUE_FOUND = 10;
	public static final int VALUE_SEARCH = -1;

	public Coin() {

	}

	public Coin(Long id) {
		super(id);

	}

	private long value;

	@ManyToOne
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Coin(long value) {
		super();
		this.value = value;

	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}

}
