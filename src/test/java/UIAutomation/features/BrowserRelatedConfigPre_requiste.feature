Feature: Load all pre-requiste before scenario running

  Background:

  Scenario Outline:To Load the specific browser with all desired capabilities

    Given Load the Browser  with desired capabilities
    When  Browser should be Launched and URL should be opened
    Then  Home Page should be opened with default date


    Examples:
      | Browser | URL                      |
      | 'CHROME | 'https://www.ixigo.com/' |