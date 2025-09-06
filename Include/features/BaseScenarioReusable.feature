@Test
Feature: Test for integration to selenium behaviour

  @Test
  Scenario: Go To Login Page Katalon Demo Health & Login
    Given user open website https://katalon-demo-cura.herokuapp.com
     When user click element element/Login/iconToggleSidebar
      And user click element element/Login/loginHyperlinkSidebar
     Then user verify element element/Login/passwordFieldLoginPage is shown
     
     When user input John Doe to element element/Login/usernameFieldLoginPage
      And user input ThisIsNotAPassword to element element/Login/passwordFieldLoginPage
      And user click element element/Login/buttonLogin
     Then user verify element element/Login/textValidationSuccessLogin is shown