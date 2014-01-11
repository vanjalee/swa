package at.ac.tuwien.swa.web.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;
import org.springframework.context.annotation.Scope;

import at.ac.tuwien.swa.web.model.WindowModel;

@Named
@Scope("request")
public class WindowController {

	@Inject
	private WindowModel windowModel;

	public void setWindowModel(WindowModel windowModel) {
		this.windowModel = windowModel;
	}

	public WindowModel getWindowModel() {
		return windowModel;
	}

	public void onTabChange(TabChangeEvent event) {
		TabView tabView = (TabView) event.getComponent();
		windowModel.setCurrentTabIndex(tabView.getChildren().indexOf(event.getTab()));
		clearTabStates();
	}

	private void clearTabStates() {
		closeCustomerSecDialog();
		closeCustomerNewSecDialog(true);
	}

	public boolean isTabCustomer() {
		return windowModel.getCurrentTabIndex() == 2;
	}

	public boolean isTabRoom() {
		return windowModel.getCurrentTabIndex() == 1;
	}

	public void openCustomerSecDialog() {
		windowModel.setCustomerSecDialog(true);
	}

	public void openCustomerNewSecDialog() {
		windowModel.setCustomerNewSecDialog(true);
	}

	public void closeCustomerSecDialog() {
		windowModel.setCustomerSecDialog(false);
	}

	public void closeCustomerNewSecDialog(boolean cancel) {
		windowModel.setCustomerNewSecDialog(false);
		if (!cancel && windowModel.isCustomerSecDialog()) {
			closeCustomerSecDialog();
		}
	}

}
