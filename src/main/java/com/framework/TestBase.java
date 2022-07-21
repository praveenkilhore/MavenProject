package com.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.enums.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;


public class TestBase {
	public static WebDriver driver;
	public static Properties configProperties;
	public static String user = "Admin";
	public static String password = "admin123";

	public TestBase() {
		try {
			loadConfigProperty();
		} catch (Exception e) {
			System.out.println("Unable to lead Config Props: " + e.getMessage());
		}
	}

	public void launchBrowser(String browser, boolean headless) {

		if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
			//WebDriverManager webDriverManager = new ChromeDriverManager();
			WebDriverManager.chromedriver().clearCache();
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("disable-notifications");
			if (headless==true) {
				chromeOptions.addArguments("--headless");
			}

			driver = new ChromeDriver(chromeOptions);

		} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name()))

		{
			WebDriverManager webDriverManager = new FirefoxDriverManager();
			WebDriverManager.firefoxdriver().clearCache();
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

	}

	public void goToHomePage(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		
	}

	private void loadConfigProperty() throws IOException {
		configProperties = new Properties();
		FileInputStream configPropertiesStream = new FileInputStream("src/test/resources/config.properties");
		configProperties.load(configPropertiesStream);
	}

	public static Properties getConfigProp() {
		return configProperties;
	}

	public void switchToFrame(String frameId) throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame(frameId);
	}
	
	public void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void explicitWait(WebElement element,int time) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
