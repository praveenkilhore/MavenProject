Feature: Test Background Feature
Description: The purpose of this feature is to test the Background keyword

Background: Free HRM Valid Login Credentials Test Scenario
			Given user is already on Login Page
			When title of login page is OrangeHRM
			Then user enters valid username and password
			Then user clicks on login button
			Then Validate Welcome Profile
			
Scenario Outline: Free HRM Search Add new Employee Test Scenario
			Given mouse over PIM Tab
			Then click on Add Employee Tab
			Then fullname <firstname> and <lastname>
			Then upload photograph
			Then tick checkBox
			Then fields <user_name> and <user_password> and <repassword> and <status>
			Then hit save button

Examples:
	| firstname | lastname | user_name | user_password | repassword | status |
	| Praveen | Kilhore | praveen | test@123 | test@123 | Enabled |

Scenario: Free HRM Delete UserTest Scenario
			Given mouse hover Admin Tab
			Then mouse hover User Management Tab
			Then press Users
			Then select the user to be deleted
			Then Click on Delete Button