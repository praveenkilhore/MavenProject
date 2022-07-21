package com.Cucumber_Demo.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.framework.TestBase;

public class Add_New_Employee_Object extends TestBase {

	Actions action = new Actions(driver);
	Select status_list;
	
	@FindBy(xpath = "//a[@id = 'menu_pim_viewPimModule']")
	WebElement PIMTab;
	
	@FindBy(xpath = "//a[@id = 'menu_pim_addEmployee']")
	WebElement addEmployeeTab;
	
	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='photofile']")
	WebElement chooseFile;
	
	@FindBy(xpath = "//input[@id='chkLogin']")
	WebElement create_Login_Details;
	
	@FindBy(id = "user_name")
	WebElement user_name;
	
	@FindBy(id = "user_password")
	WebElement user_password;
	
	@FindBy(id = "re_password")
	WebElement re_password;
	
	@FindBy(id = "status")
	WebElement status;
	
	@FindBy(xpath = "//input[@id = 'btnSave' and @type='button']")
	WebElement btnSave;
	
	@FindBy(xpath = "//div[@id='profile-pic']/child::h1")
	WebElement name_AfterAdding_employee;
	
	public Add_New_Employee_Object() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void move_mouse_to_PIM_tab() {
		explicitWait(PIMTab, 1);
		action.moveToElement(PIMTab).build().perform();
	}
	
	public void click_on_adddEmployee_tab() {
		explicitWait(addEmployeeTab, 1);
		
		addEmployeeTab.isDisplayed();
		addEmployeeTab.click();
	}
	
	public void enter_firstname_lastname(String firstName, String lastName) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
	}
	
	public void choose_FileToUpload() {
		chooseFile.sendKeys("C:\\Users\\Praveen Kilhore\\desktop\\new.png");
	}
	
	public void click_CreateLoginDetails_checkBox() {
		create_Login_Details.click();
	}
	
	public void enter_username_password_status(String userName, String password, String repassword) {
		explicitWait(user_name, 1);
		
		user_name.sendKeys(userName);
		user_password.sendKeys(password);
		re_password.sendKeys(repassword);
	}
	
	public void select_Status(String stat) {
		status_list = new Select(status);
		status_list.selectByVisibleText(stat);
	}
	
	public void click_on_SaveBtn() {
		btnSave.click();
	}
	
//	public String employee_successfully_added() throws InterruptedException {
//		//explicitWait(name_AfterAdding_employee, 5);
//		Thread.sleep(2000);
//		name_AfterAdding_employee.isDisplayed();
//		Thread.sleep(4000);
//		return(name_AfterAdding_employee.getText());
//	}
	
}
