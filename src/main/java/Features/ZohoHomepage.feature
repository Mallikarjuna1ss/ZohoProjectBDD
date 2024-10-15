Feature: Zoho Homepage Top Menu Bar
@skip
  Scenario: Verify top menu bar elements on the Zoho homepage
    Given the user is on the Zoho homepage
    Then the user checks the top menu bar

@skip
  Scenario: Verify Products button functionality
    Given I am on the homepage
    When I click on the "Products" button
    Then I should see the products menu expanded
  @skip  
    Scenario: Navigate to Customers page
    Given I am on the homepage
    When I click on the "Customers" link
    Then I should be navigated to the "customers.html" page
     @skip    
     Scenario: Verify Company dropdown functionality
    Given I am on the homepage
    When I expand the "Company" dropdown
    Then I should see the following options:
      | About us     |
      | Our story    |
      | Rural revival|
      | Press        |
      | Events       |
      | Careers      |
      | Humans of Zoho |
      | The Long Game|
    @skip    
   Scenario: Verify More Links dropdown functionality
    Given I am on the homepage
    When I expand the "More Links" dropdown
    Then I should see the following options:
  | Blog           |
  | Community      |
  | Find a Partner |
  | Support        | 
  | Contact us     |
  
@skip
Scenario: Verify "Sign In" button in the top bar
    Given I am on the homepage
    When I look for the "Sign In" button
    Then the "Sign In" button should be visible
   @skip 
     Scenario: Verify "Search" icon functionality
    Given I am on the homepage
    When I click on the "Search" icon1
    Then the search bar should be displayed
  @skip  
    Scenario: Verify "Notification" icon functionality
    Given I am on the homepage
    When I click on the "Notification" icon
    Then the notifications panel should be displayed
    

 