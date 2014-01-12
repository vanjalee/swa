package at.ac.tuwien.swa.web.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import at.ac.tuwien.swa.entities.User;
import at.ac.tuwien.swa.service.UserService;
import at.ac.tuwien.swa.web.model.UserModel;

@Named
@Scope("request")
public class UserController {

	@Inject
	private UserModel userModel;

	private boolean newUser;

	@Inject
	UserService userService;

	public void saveUser() {
		userService.save(userModel.getUser());

		findAll();
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	public void createNewUser() {
		userModel.setUser(new User());
	}

	public void removeUser() {

		userService.delete(userModel.getUser());
		userModel.setUser(new User());

		findAll();
	}

	public void editUser(User user) {
		userModel.setUser(user);
	}

	public boolean isNewUser() {
		return newUser;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void findAll() {
		userModel.setSearchResult(userService.findAll());
	}

}
