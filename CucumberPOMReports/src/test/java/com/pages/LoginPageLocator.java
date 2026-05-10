package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {
	@FindBy(xpath="//input[@name='username']")
	public WebElement uname;
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	@FindBy(xpath= "//button[@type='submit']")
	public WebElement loginbtn;
}
