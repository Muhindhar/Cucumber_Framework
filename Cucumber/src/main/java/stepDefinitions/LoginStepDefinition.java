package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	@Given("user is on home page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("1");
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("1");
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("1");
	}

	@Then("user should be able to login sucessfully")
	public void user_should_be_able_to_login_sucessfully() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("1");
	}
}
