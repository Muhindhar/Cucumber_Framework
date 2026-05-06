package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.Before;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginStep {
    WebDriver driver;
  //  WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ✅ important
    }

    @Given("the user is on home page")
    public void the_user_is_on_home_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
            .sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
            .sendKeys(password);
    }

    @When("user clicks Login button")
    public void user_clicks_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user should be able to see an {string}")
    public void user_should_be_able_to_see_an(String expectedMessage) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualMessage;

        if(expectedMessage.equals("Invalid credentials")) {

            actualMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'oxd-alert-content')]//p")
                )
            ).getText();

        } else {

            actualMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(@class,'oxd-input-field-error-message')]")
                )
            ).getText();
        }

        Assert.assertEquals(actualMessage.trim(), expectedMessage);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}