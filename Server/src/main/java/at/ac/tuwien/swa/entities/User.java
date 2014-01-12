package at.ac.tuwien.swa.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "reg_user")
@Table
public class User extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8452165418485031475L;

	public User() {

	}

	public User(Long id) {
		super(id);

	}

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private String notiz;
	private String email;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Peer> peers = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Coin> coins = new ArrayList<>();

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setPeers(List<Peer> peers) {
		this.peers = peers;
	}

	public List<Peer> getPeers() {
		return peers;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNotiz() {
		return notiz;
	}

	public void setNotiz(String notiz) {
		this.notiz = notiz;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
