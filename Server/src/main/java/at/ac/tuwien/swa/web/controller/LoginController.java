package at.ac.tuwien.swa.web.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import at.ac.tuwien.swa.web.model.LoginModel;

@Named
@Scope("session")
public class LoginController implements Serializable {

	private static final long serialVersionUID = -8265492618855656548L;

	@Inject
	private LoginModel loginModel;

	public void doLogout() {
		loginModel.setLogin(false);
	}

	public void doLogin() {
		loginModel.setLogin(true);
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}
}
