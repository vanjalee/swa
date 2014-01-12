package at.ac.tuwien.swa.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import at.ac.tuwien.swa.entities.User;
import at.ac.tuwien.swa.service.UserService;
import at.ac.tuwien.swa.web.model.LoginModel;
import at.ac.tuwien.swa.web.model.UserModel;
import at.ac.tuwien.swa.web.model.WindowModel;

@Named
@Scope("request")
public class UserController {

	@Inject
	private UserModel userModel;

	private boolean newUser;

	@Inject
	UserService userService;

	@Inject
	LoginModel loginModel;

	@Inject
	WindowModel windowModel;

	public void registerUser() {
		if (!userService.usernameExists(userModel.getUser().getUsername())) {
			userService.save(userModel.getUser());
			windowModel.setCurrentTabIndex(0);
			loginModel.setLogin(true);
		}
		else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "username: '" + userModel.getUser().getUsername() + "' is not available", null));
			userModel.getUser().setUsername(null);
			userModel.getUser().setPassword(null);
		}

	}

	public void saveUser() {
		if (loginModel.isLogin()) {
			userService.save(userModel.getUser());
			findAll();
		}
		else {
			registerUser();
		}
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
		loginModel.setLogin(false);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "user successfully removed", null));
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
