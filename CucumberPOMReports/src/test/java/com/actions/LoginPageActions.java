package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.pages.LoginPageLocator;
import com.utilities.HelperClass;

public class LoginPageActions {
	LoginPageLocator loginpagelocator = null;
	String strusername,strpassword;
	
	public LoginPageActions() {
		this.loginpagelocator = new LoginPageLocator();
		PageFactory.initElements(HelperClass.getDriver(), loginpagelocator);
	}
	public void setUsername(String strusername) {
		loginpagelocator.uname.sendKeys(strusername);
	}
	public void setPassword(String strpassword) {
		loginpagelocator.password.sendKeys(strpassword);
	}
	public void clickloginbtn() {
		loginpagelocator.loginbtn.click();
	}
	public void login() {

		File file = new File(
				"C:\\Users\\Muhindhar S V\\eclipse-workspace\\CucumberPOMReports\\src\\test\\resources\\testdata.properties");

		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		strusername = prop.getProperty("username");
		System.out.println("Username : " + strusername);

		strpassword = prop.getProperty("password");
		System.out.println("Password : " + strpassword);

		this.setUsername(strusername);
		this.setPassword(strpassword);
		this.clickloginbtn();
	}
}
