@search
Feature: Etsy Search Functionality
  Background: Navigate to Etsy
    Given the user navigates to "https://www.etsy.com/"

  @hat @tc1 @smoke @regression
  Scenario: Validation of etsy search Hat
    When the search with "Hat"
    Then the user should see the title "Hat | Etsy"

  @hat @tc2 @smoke @regression
  Scenario: Validation of etsy search Chocolate
    When the search with "Chocolate"
    Then the user should see the title "Chocolate | Etsy"

  @hat @tc3 @regression
  Scenario: Validation of etsy search Pin
    When the search with "Pin"
    Then the user should see the title "Pin | Etsy"