package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin="pretty",features="src\\test\\resources\\com\\features\\Login.feature",
tags="@Valid",glue="com.cucumber.LoginStepDefinitin.definitions")

public class JunitRunner {

}
