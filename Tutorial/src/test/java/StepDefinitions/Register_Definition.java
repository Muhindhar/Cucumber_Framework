package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_Definition {
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Given("the user is on tutorialsninja site")
	public void the_user_is_on_tutorialsninja_site() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://tutorialsninja.com/demo/");
	}

	@When("user clicks on MyAccount link and Click Register link")
	public void user_clicks_on_my_account_link_and_click_register_link() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<Map<String,String>> reg = dataTable.asMaps(String.class,String.class);
		Map<String,String> row = reg.get(0);
		
		driver.findElement(By.name("firstname")).sendKeys(row.get("First Name"));
		driver.findElement(By.name("lastname")).sendKeys(row.get("Last Name"));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(row.get("E-mail"));
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(row.get("Telephone"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(row.get("Password"));
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys(row.get("Password confirm"));
		driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@Then("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		System.out.println("Account created");
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
