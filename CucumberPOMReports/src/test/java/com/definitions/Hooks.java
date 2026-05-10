package com.definitions;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.utilities.HelperClass;
import java.io.File;
import java.io.IOException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private static final Logger logger = LogManager.getLogger(Hooks.class);
	@Before
	public static void setup() {
		HelperClass.setupDriver();
		HelperClass.getDriver().navigate().refresh();
		logger.info("Scenario started");
	}
	@After
	public static void Teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			File screenshotfile = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
			
			try {
				File destfile = new File("screenshots/"+scenario.getName().replaceAll(" ", "_")+".png");
				FileUtils.copyFile(screenshotfile, destfile);
				byte[]screenshotbytes = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshotbytes,"image/png", "Failure screenshot");
				logger.error("Scenario failed : "+scenario.getName());
			}
			catch(IOException e) {
				logger.error("failed to take screenshot"+e.getMessage());
			}
		}
		else {
			logger.info("Scenario passed:"+scenario.getName());
		}
		HelperClass.teardown();
	}
}