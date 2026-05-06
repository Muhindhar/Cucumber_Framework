package Runner;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
public class RegisterRunner {
	@CucumberOptions(plugin= {"pretty","html:target/cucucmber-reports/Cucumber.html"},
	features="src/test/resources/com/Features/Register.feature",
	glue="StepDefinitions")

	public class TestngReport extends AbstractTestNGCucumberTests{

	}
}
