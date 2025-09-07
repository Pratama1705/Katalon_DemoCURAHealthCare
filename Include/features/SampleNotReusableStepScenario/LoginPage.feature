@LoginPage
Feature: Login
  Background:
  Given I open website page and navigate to login page

  @Testing
  Scenario Outline: Login Failed - Invalid Username & Password
    When I input username <username> or password <password> with incorrect value
    Then I see validation not able to login

    Examples: 
      | username         | password            |
      | Akbar Pratama    | ThisIsNotAPassword  |
      | John Doe         | InvalidPassword     |
	
  Scenario Outline: Login Success
    When I input username <username> and password <password> with correct value
    Then I successfully login

    Examples: 
      | username    | password            |
      | John Doe    | ThisIsNotAPassword  |