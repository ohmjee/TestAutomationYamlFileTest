Feature: Login in Orange HRM

  @Test
  Scenario Outline: Test Login
    Given Launch the given Browser with URL "<URL>"
    When user has Username and Password
    Then User should be able to login
    Examples:
      | Browser | URL                                        |
      | FIREFOX | https://opensource-demo.orangehrmlive.com/ |