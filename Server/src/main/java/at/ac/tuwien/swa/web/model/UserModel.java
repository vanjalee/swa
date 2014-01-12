package at.ac.tuwien.swa.web.model;

import java.util.List;

import javax.inject.Named;

import at.ac.tuwien.swa.entities.User;

@Named
public class UserModel {
	private User user;

	private List<User> searchResult;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public List<User> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<User> searchResult) {
		this.searchResult = searchResult;
	}
}
