@outline
Feature: Etsy search With Scenario Outline

  Background: : Navigate
    Given the user navigates to "https://www.etsy.com/"

  Scenario Outline: Etsy search Validation
    When the search with "<searchValue>"
    Then the user should see the title "<title>"
    Examples:
      | searchValue | title             |
      | Hat         | Hat \| Etsy       |
      | Chocolate   | Chocolate \| Etsy |
      | Pin         | Pin \| Etsy       |
