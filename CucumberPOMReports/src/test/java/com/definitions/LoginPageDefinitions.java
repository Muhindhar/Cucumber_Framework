package com.definitions;

import org.testng.Assert;

import com.actions.DashBoardActions;
import com.actions.LoginPageActions;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinitions {
	LoginPageActions objlogin = new LoginPageActions();
	DashBoardActions objdash = new DashBoardActions();

	@Given("the user is on HRMLogin page {string}")
	public void the_user_is_on_hrm_login_page(String string) {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.openPage(string);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		// Write code here that turns the phrase above into concrete actions
		objlogin.login();
	}

	@Then("user should be able to login successfully and should see the dashboard")
	public void user_should_be_able_to_login_successfully_and_should_see_the_dashboard() {
		// Write code here that turns the phrase above into concrete actions
		String exp="Dashboar";
		Assert.assertEquals(exp, objdash.getdashtext());
	}
}
