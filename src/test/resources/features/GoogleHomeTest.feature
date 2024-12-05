Feature: Google Search

  Scenario Outline: Search in Google
    Given browser is open
    And User is on google search page
    When User enters "<searchText>" in the search box
    And hits Enter
    Then User is navigated to the search results page containing "<searchText>"

  Examples:
    | searchText    | expectedText            |
    | Cucumber Test | Test automation Software |
    | Selenium      | Selenium WebDriver      |
