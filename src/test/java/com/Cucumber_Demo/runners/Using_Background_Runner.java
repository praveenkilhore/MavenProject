package com.Cucumber_Demo.runners;

import com.framework.TestBase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/features/Using_BackgroundKeyword.feature",
		glue={"com.Cucumber_Demo.stepdefinitions"},
		plugin= {"pretty","html:target/cucumber-html-report","json:target/cucumber.json",
				"rerun:target/cucumber-reports/failedrun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true, 
		dryRun = false,
		publish = true)

public class Using_Background_Runner extends AbstractTestNGCucumberTests {
TestBase testbase;
}
