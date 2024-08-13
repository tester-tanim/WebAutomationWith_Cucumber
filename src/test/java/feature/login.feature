Feature: Login feature
  Background:
    Given User should be on the login screen

  @sanity
  Scenario: User should be able to log in with valid credentials
    When User enter valid username and password
    And User click on the login button
    Then User should be navigate to the inventory page
    But User shouldn't be on the login page

  @login @smoke
  Scenario: User should not be able to login with an invalid password
    When User enter "standard_user" on the username filed
    And User enter "secret_s" on the password filed
    And User click on the login button
    Then User should see "Epic sadface: Username and password do not match any user in this service" error message

  Scenario: User should not be able to login without username
    When User enter "secret_sauce" on the password filed
    And User click on the login button
    Then User should see "Epic sadface: Username is required" error message

  Scenario: User should not be able to login without password
    When User enter "standard_user" on the username filed
    And User click on the login button
    Then User should see "Epic sadfac: Password is required" error message

  Scenario: User should not be able to login without username and password
    When User click on the login button
    Then User should see "Epic sadface: Username is required" error message

  Scenario Outline: User should not be able to login with invalid credentials
    When User enter <username> on the username filed
    And User enter <password> on the password filed
    And User click on the login button
    Then User should see <error_msg> error message
    Examples:
      | username      | password     | error_msg                                                                 |
      |"standard_user"|"secret_s"    |"Epic sadface: Username and password do not match any user in this service"|
      |"standard_user"|""            |"Epic sadface: Password is required"                                       |
      |""             |"secret_sauce"| "Epic sadface: Username is required"                                      |
      |""             |""            |"Epic sadface: Username is required"                                       |