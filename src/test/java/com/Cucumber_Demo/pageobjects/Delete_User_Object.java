package com.Cucumber_Demo.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.TestBase;

public class Delete_User_Object extends TestBase {

	Actions action = new Actions(driver);
	
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement AdminTab;
	
	@FindBy(id = "menu_admin_UserManagement")
	WebElement UserManagementTab;
	
	@FindBy(id = "menu_admin_viewSystemUsers")
	WebElement UsersTab;
	
	@FindBy(xpath = "//a[contains(text(),'praveen')]/parent::td/preceding-sibling::td/child::input[@type='checkbox']")
	WebElement user_toDelete;	
	
	@FindBy(id = "btnDelete")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//div[@class='modal-footer']//input[@id='dialogDeleteBtn' and @value='Ok']")
	WebElement confirm_Delete;
	
	
	public Delete_User_Object() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void move_mouse_to_admin_tab() {
		action.moveToElement(AdminTab).build().perform();
	}
	
	public void move_mouse_to_UserManagement_tab() {
		explicitWait(UserManagementTab, 1);
		UserManagementTab.isDisplayed();
		action.moveToElement(UserManagementTab).build().perform();
	}
	
	public void click_on_Users_tab() {
		explicitWait(UsersTab, 1);
		
		UsersTab.isDisplayed();
		UsersTab.click();
	}
	
	public void click_checkbox_forUserToBeDeleted() {
		user_toDelete.isSelected();
		
		user_toDelete.click();
	}
	
	public String click_on_DeleteButton() {
		deleteBtn.click();
		
		confirm_Delete.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		String message = el.getText();
		
		return(message);
	}
	
}
