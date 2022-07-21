package com.Cucumber_Demo.stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.Cucumber_Demo.pageobjects.Add_New_Employee_Object;
import com.Cucumber_Demo.pageobjects.Delete_User_Object;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.framework.Login_Functions;
import com.framework.TestBase;

import io.cucumber.java.en.*;


public class Using_Background_StepDefinition {
	
	private final Login_Functions login;
	private final Delete_User_Object delete;
	private final Add_New_Employee_Object add_emp;

	public Using_Background_StepDefinition() throws IOException {
		login= new Login_Functions();
		delete = new Delete_User_Object();
		add_emp= new Add_New_Employee_Object();
	}
	
	@Given("user is already on Login Page")
	public void user_is_already_on_login_page() {
		TestBase testBase = new TestBase();	
		testBase.goToHomePage(TestBase.getConfigProp().getProperty("url"));
		ExtentCucumberAdapter.addTestStepLog("Browser Launched Successfully");
	}

	@When("title of login page is OrangeHRM")
	public void title_of_login_page_is_OrangeHRM() {
	    String title = login.checkTitle();
	    Assert.assertEquals("OrangeHRM", title);
	}

	@Then("^user enters valid username and password$")
	public void user_enters_valid_username_and_password() {
	    login.EnterUsername();
	    login.EnterPassword();
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
	   login.ClickOnLoginButton();
	}
	
	@Then("Validate Welcome Profile")
	public void validate_welcome_profile() {
	    String welcome_msg = login.validate_login();
	    
	    Assert.assertTrue(welcome_msg.contains("Welcome"));
	}
	
	@Given("^mouse hover Admin Tab$")
	public void mouse_hover_Admin_Tab() {
	   delete.move_mouse_to_admin_tab();
	}
	
	@Then("^mouse hover User Management Tab$")
	public void mouse_hover_User_Management_Tab() {
	   delete.move_mouse_to_UserManagement_tab();
	}
	
	@Then("^press Users$")
	public void press_Users() {
	   delete.click_on_Users_tab();
	}
	
	@Then("^select the user to be deleted$")
	public void select_the_user_to_be_Deleted() {
		delete.click_checkbox_forUserToBeDeleted();
	}
	
	@Then("^Click on Delete Button$")
	public void Click_on_Delete_Button() {
		String result = delete.click_on_DeleteButton();
		System.out.println(result);
		
		Assert.assertEquals("Successfully Deleted", result);
	}
	
	@Given("^mouse over PIM Tab$")
	public void mouse_over_PIM_Tab() {
		add_emp.move_mouse_to_PIM_tab();
	}
	
	@Then("^click on Add Employee Tab$")
	public void click_on_Add_Employee_Tab() {
		add_emp.click_on_adddEmployee_tab();
	}
	
	@Then("^fullname (.*) and (.*)$")
	public void enter_fullname(String firstName, String lastName) {
		add_emp.enter_firstname_lastname(firstName, lastName);
	}
	
	@Then("^upload photograph$")
	public void upload_photograph() {
		add_emp.choose_FileToUpload();
	}
	
	@Then("^tick checkBox$")
	public void tick_checkBox() {
		add_emp.click_CreateLoginDetails_checkBox();
	}
	
	@Then("^fields (.*) and (.*) and (.*) and (.*)$")
	public void fill_in_fields_userName_userPassword_rePassword_status(String user_name, String user_password, String repassword, String status) {
		add_emp.enter_username_password_status(user_name, user_password, repassword);
		add_emp.select_Status(status);
	}
	
	@Then("^hit save button$")
	public void hit_save_button() throws InterruptedException {
	   add_emp.click_on_SaveBtn();
	   
	   String result = add_emp.employee_successfully_added();
	   System.out.println(result);
	   Assert.assertEquals("Praveen Kilhore", result);
	}
	
}
