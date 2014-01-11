package at.ac.tuwien.swa.web.model;

import javax.inject.Named;

@Named
public class WindowModel {
	private int currentTabIndex = 0;

	private boolean customerNewSecDialog;

	private boolean customerSecDialog;

	public void setCurrentTabIndex(int currentTabIndex) {
		this.currentTabIndex = currentTabIndex;
	}

	public int getCurrentTabIndex() {
		return currentTabIndex;
	}

	public boolean isCustomerNewSecDialog() {
		return customerNewSecDialog;
	}

	public boolean isCustomerSecDialog() {
		return customerSecDialog;
	}

	public void setCustomerSecDialog(boolean customerSecDialog) {
		this.customerSecDialog = customerSecDialog;
	}

	public void setCustomerNewSecDialog(boolean customerNewSecDialog) {
		this.customerNewSecDialog = customerNewSecDialog;
	}
}
