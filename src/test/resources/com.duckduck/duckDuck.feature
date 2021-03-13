Feature: DuckDuckGo search
  Scenario: Search for selenium on DuckDuckGo

    Given user is on DuckDuckGo page
    When user searches for selenium
    Then user sees results about selenium
    And the results contains Selenium keywords
