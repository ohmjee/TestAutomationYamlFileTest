@Test
Feature: Launch the Browser with Desired setting and URL

  Scenario Outline:
    Given Launch the given Browser "<Browser>"
    When enter the URL "<URL>" in the address bar of the browser
    Then URL should be launched
    And Login Page should be visible

    Examples:
      | Browser | URL                                        |
      | CHROME  | https://opensource-demo.orangehrmlive.com/ |