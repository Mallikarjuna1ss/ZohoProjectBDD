@SignIn 
Feature: User Login Functionality 

Scenario: Successfully log in with valid credentials 
	Given the user is on the Zoho homepage 
	And the user clicks on the Sign In button 
	And the user enters the username 
	And the user clicks on the Next button 
	And the user enters the password 
	And the user clicks on the Final Sign In button 
    Then the user should be redirected to the Zoho dashboard page
	
	
	
	
