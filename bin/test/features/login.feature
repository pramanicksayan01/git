Feature: Amazon login feature

  Background: login page
    Given user on the login page
    When user enters id
    And click on continue
    And enter password
    Then click on sign in
    And user should be on homepage
@Tagh
  Scenario: homepage
    Given user should be logged in
    When user clicks on cart button
    And user clicks on select all items
    And user clicks on dropdown button
    And user selects quantity
    And user verify the cart amount
    Then user clicks on proceed to buy
@Tags
  Scenario: Serach functionality
    Given user on the homepage
    When user clicks on All button
    And user serach for <pname> product 
    Then user clicks on searchbutton
    And user clicks on the product
    
       
       Examples:
       |pname|
       |"Apple watch"|
