package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MultipleValuestepDef {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Given("user is on HrmLogin Page")
    public void user_is_on_hrm_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Then("user enters the invalid credentials and login will be unsuccessful with cus")
    public void user_enters_invalid_credentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String username = row.get("username");
            String password = row.get("password");
            String expectedMessage = row.get("errormessage");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).clear();
            driver.findElement(By.name("username")).sendKeys(username);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).clear();
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            String actualMessage;
            if (expectedMessage.equals("Invalid credentials")) {
                actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-alert-content')]//p"))).getText();
            }
            else {
                actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]"))).getText();
            }
            Assert.assertEquals(actualMessage.trim(), expectedMessage);
        }
    }
    @After
    public void teardown() {
        driver.quit();
    }
}