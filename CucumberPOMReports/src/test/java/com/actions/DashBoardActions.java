package com.actions;

import org.openqa.selenium.support.PageFactory;

import com.pages.DashBoardLocator;
import com.utilities.HelperClass;

public class DashBoardActions {
	DashBoardLocator DashboardLoc = null;
	
	public DashBoardActions(){
		this.DashboardLoc = new DashBoardLocator();
		PageFactory.initElements(HelperClass.getDriver(),DashboardLoc );
	}
	public String getdashtext() {
		return DashboardLoc.dashboard.getText();
	}
}
