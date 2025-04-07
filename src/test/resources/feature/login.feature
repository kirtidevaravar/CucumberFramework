
@login
Feature: Test all login related feature

  @smoke @regression @master
  Scenario: Login to application using valid username and Password 1
    Given As a user I want to launch the application
    And I need to click on login link
    When I enter a valid username
    And I enter a valid password
    And I need to click on login button
    Then  I should login successfully

  @smoke @regression @master
  Scenario: Login to application using valid username and Password 2
    Given As a user I want to launch the application
    And I need to click on login link
    When I enter a valid username
    And I enter a valid password
    And I need to click on login button
    Then  I should login successfully

  @regression @master
  Scenario: Login to application using invalid username and Password 3
    Given As a user I want to launch the application
    And I need to click on login link
    When I enter a invalid username
    And I enter a invalid password
    And I need to click on login button
    Then  I should not login successfully

  @regression @master
  Scenario: Login to application using invalid username and Password 4
    Given As a user I want to launch the application
    And I need to click on login link
    When I enter a invalid username
    And I enter a invalid password
    And I need to click on login button
    Then  I should not login successfully

  @regression @master
  Scenario: Login to application using invalid username and Password 5
    Given As a user I want to launch the application
    And I need to click on login link
    When I enter a invalid username
    And I enter a invalid password
    And I need to click on login button
    Then  I should not login successfully

  @regression @master
  Scenario: Login to application using invalid username and Password 6
    Given As a user I want to launch the application
    And I need to click on login link
    When I enter a invalid username
    And I enter a invalid password
    And I need to click on login button
    Then  I should not login successfully

  @regression @master @datadriven
  Scenario Outline: User login with different credentials
    Given As a user I want to launch the application
    And I need to click on login link
    When user enters email "<email>" and password "<password>"
    And I need to click on login button
    Then The login "<expectedResult>" should be displayed

    Examples:
      | email          | password | expectedResult |  |
      | vidu@gmail.com | vidu123  | success        |  |
      | vii@gmail.com  | vidu123  | login error    |  |
      |                |          | login error    |  |




