Feature: Login to hrm application
 @validInput
 Scenario: login with valid credentials
 	Given the user is on HRMLogin page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
 	When user enters username and password
 	Then user should be able to login successfully and should see the dashboard
 