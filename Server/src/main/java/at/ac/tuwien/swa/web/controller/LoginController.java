package at.ac.tuwien.swa.web.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import at.ac.tuwien.swa.entities.User;
import at.ac.tuwien.swa.service.UserService;
import at.ac.tuwien.swa.web.model.LoginModel;
import at.ac.tuwien.swa.web.model.UserModel;

@Named
@Scope("session")
public class LoginController implements Serializable {

	private static final long serialVersionUID = -8265492618855656548L;

	@Inject
	private LoginModel loginModel;

	@Inject
	UserModel userModel;

	@Inject
	UserService userService;

	public void doLogout() {
		loginModel.setLogin(false);
		userModel.setUser(new User());
	}

	public void doLogin() {

		User user = null;
		try {
			user = userService.getUser(userModel.getUser().getUsername(), userModel.getUser().getPassword());
			if (user != null) {
				loginModel.setLogin(true);
			}
		}
		catch (Exception e) {
		}
		if (user == null) {
			doLogout();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "username or password is invalid", null));
		}
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}
}
