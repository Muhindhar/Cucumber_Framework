package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Collections;
import java.util.List;

public class LoginDataTable {
	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("the user is on home page")
	public void the_user_is_on_home_page() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		System.out.println("Adding");
		List<List<String>> signup = dataTable.asLists();
		String username;
		String password;
		for(int i=0;i<1;i++) {
			for(int j=0;j<1;j++) {
				driver.findElement(By.xpath("//input[@name='username']"));
				driver.findElement(By.xpath("//input[@name='password']"));
				driver.findElement(By.xpath("//button[@type='submit']")).click();
			}
		}
	}

@Then("user should be able to see an homepage")
public void user_should_be_able_to_see_an_homepage() {
    // Write code here that turns the phrase above into concrete actions
   System.out.println("LoggedIn");
}

}
