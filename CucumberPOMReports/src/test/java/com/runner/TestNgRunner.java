package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestNgRunner {
	
	@CucumberOptions(
			features = "src\\test\\resources\\Features\\LoginPage.feature",
			glue = "com.definitions",
			plugin = { "pretty",
						"html:target/cucucmber-reports.html" ,
						"json:taget/cucumber.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			},
			monochrome=true)

public class TestngReport extends AbstractTestNGCucumberTests {

}

}
