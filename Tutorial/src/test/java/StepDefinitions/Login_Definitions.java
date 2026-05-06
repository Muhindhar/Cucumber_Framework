package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Definitions {
	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Given("the user is on homepage")
	public void the_user_is_on_homepage() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}

	@When("user clicks on MyAccount link and Click Login link")
	public void user_clicks_on_my_account_link_and_click_login_link() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	}

	@When("user enters mail as {string} and Password as {string}")
	public void user_enters_mail_as_and_password_as(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(string);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(string2);
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
