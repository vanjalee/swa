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
	}
}
