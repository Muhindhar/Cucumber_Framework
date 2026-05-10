package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features= {"src\\test\\resources\\Features\\LoginPage.feature"},
glue= {"com.definitions"}, plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class Allurereport extends AbstractTestNGCucumberTests {
	@Override
	  @DataProvider(parallel = true)
	  public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
