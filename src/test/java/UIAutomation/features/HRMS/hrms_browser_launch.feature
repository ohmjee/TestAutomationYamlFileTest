Feature: Launch the Browser with Desired setting and URL

  Scenario Outline:
    Given Launch the given Browser "<Browser>"
    When enter the URL "<URL>" in the address bar of the browser


    Examples:
      | Browser | URL                                        |
      | FIREFOX  | https://opensource-demo.orangehrmlive.com/ |