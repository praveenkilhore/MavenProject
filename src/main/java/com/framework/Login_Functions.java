package com.framework;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Functions extends TestBase {
	
	@FindBy(name = "txtUsername")
	WebElement username;

	@FindBy(name = "txtPassword")
	WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@id='welcome']")
	WebElement welcome_profile;
	
	public Login_Functions()throws IOException {
		PageFactory.initElements(driver, this);		
	}

	public String checkTitle() {
		return(driver.getTitle());
	}
	
	public void EnterUsername() {
		username.sendKeys(user);
	}

	public void EnterPassword() {
		Password.sendKeys(password);
	}
	
	public void ClickOnLoginButton() {
		loginBtn.click();
	}
	
	public String validate_login() {
		return(welcome_profile.getText());
	}
}
