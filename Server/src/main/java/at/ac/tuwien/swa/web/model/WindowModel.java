package at.ac.tuwien.swa.web.model;

import javax.inject.Named;

@Named
public class WindowModel {
	private int currentTabIndex = 0;

	private boolean userNewSecDialog;

	private boolean userSecDialog;

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public boolean isUserNewSecDialog() {
		return userNewSecDialog;
	}

	public boolean isUserSecDialog() {
		return userSecDialog;
	}

	public void setUserSecDialog(boolean userSecDialog) {
		this.userSecDialog = userSecDialog;
	}

	public void setUserNewSecDialog(boolean userNewSecDialog) {
		this.userNewSecDialog = userNewSecDialog;
	}
}
