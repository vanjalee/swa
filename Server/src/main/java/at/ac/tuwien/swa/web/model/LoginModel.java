package at.ac.tuwien.swa.web.model;

import java.io.Serializable;

import javax.inject.Named;

@Named
public class LoginModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4138916993621687261L;
	private boolean login;

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isLogin() {
		return login;
	}
}
