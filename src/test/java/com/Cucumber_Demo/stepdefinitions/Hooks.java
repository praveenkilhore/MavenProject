package com.Cucumber_Demo.stepdefinitions;

import com.framework.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase {

	Scenario scenario;

	@Before
	public void beforetest(Scenario scenario) {
		this.scenario = scenario;
		launchBrowser(TestBase.getConfigProp().getProperty("browser"), Boolean.parseBoolean((TestBase.getConfigProp().getProperty("headless"))));
	}

	@After(order = 0)
	public void closeDriver() {
		TestBase.driver.quit();
	}

}
