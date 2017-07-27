@testdiary
Feature: Submit the Contact Form Successfully

  @web
  Scenario: Open the Company Web page
    Given open Chrome and start Web Application
    And navigate to Contact Page
    When user is on the contact page and verify contact address
    Then Fill all the required contact fields
    Then Perform Submit Action
    Then user should be able to submit successfully

  @web
  Scenario: Validate the address not equal on contact page
    Given User is on the contact page
    Then Wrong Contact address is available to the user "1800 Griffin Rd"
 
  Scenario: Test the page load perfomance
    Given Hit "https://www.magicleap.com" 100 times
    Then Generate report with MIN, MAX and AVERAGE Time