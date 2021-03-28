@order
Feature: WebOrder Page Food Order

  @tc6  @regression
  Scenario: Validation of Food Order for Office
    Given the user is on weborder home page
    When the user selects "Office" option
    Then the user is on the group order page
    When the user send invitees note "Test"
    And the user send invite list "email" and "email"
    | Kushal@gmail.com |
    | Priyanka@gmail.com |
    | patel@gmail.com    |
    | naveen@gmail.com   |
    | gopal@gmail.com    |
    | sandeep@gmail.com  |
    | ajeesh@gmail.com   |
    | sameer@gmail.com   |
    And the user validate "View Group Order" text
    * the user validate total participant is 1