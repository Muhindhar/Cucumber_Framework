package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitin {
	
	  WebDriver driver =new ChromeDriver();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	  @Given("User in the home page click the login link button")
	  public void user_in_the_home_page_click_the_login_link_button() {
	      // Write code here that turns the phrase above into concrete actions
		  driver.manage().window().maximize();
	      driver.get("https://www.demoblaze.com/");
	      driver.findElement(By.xpath("//a[@id='login2']")).click();
	  }

	  @When("The user enters the username as {string}")
	  public void the_user_enters_the_username_as(String string) {
	      // Write code here that turns the phrase above into concrete actions
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']")));
	      driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(string);
	      
	      
	  }

	  @When("enter the password as {string}")
	  public void enter_the_password_as(String string) {
	      // Write code here that turns the phrase above into concrete actions
		  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(string);
		  }

	  @When("click the login Button")
	  public void click_the_login_button() {
	      // Write code here that turns the phrase above into concrete actions
		  driver.findElement(By.xpath("//button[text()='Log in']")).click();  }

	  @Then("user should be able to login successfully with usename")
	  public void user_should_be_able_to_login_successfully_with_usename() {
	      // Write code here that turns the phrase above into concrete actions
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='nameofuser']")));
	  String actual = driver.findElement(By.id("nameofuser")).getText();
	    Assert.assertTrue(actual.contains("Welcome"));
	  }

	  @When("The user enters the valid username as {string}")
	  public void the_user_enters_the_valid_username_as(String string) {
	      // Write code here that turns the phrase above into concrete actions
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']")));
	      driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(string);
	  }

	  @When("enter the invalid password as {string}")
	  public void enter_the_invalid_password_as(String string) {
	      // Write code here that turns the phrase above into concrete actions
		  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(string);
	  }

	  @Then("it shows an alert message")
	  public void it_shows_an_alert_message() {

	      wait.until(ExpectedConditions.alertIsPresent());
	      String alertText = driver.switchTo().alert().getText();
	      Assert.assertEquals(alertText, "Wrong password.");
	      driver.switchTo().alert().accept();  
	  }
	  @Before
		public void setup() {
		   driver =new ChromeDriver();
		   wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			
		}
		@After
		public void tearDown() {
			if(driver!=null)
			driver.quit();
		}
	  

}