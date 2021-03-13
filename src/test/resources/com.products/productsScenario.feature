Feature: Validation of Products Page

  @products
  Scenario: Validation of New Product Creation

    Given the user navigates to product website home page
    When the user enters the product info "MyMoney" and "4"
    Then the user enters the address info "Techtorial", "2200 E Devon", "Des Plaines", "IL" , "60018"
    And the user enters the card info "Visa", "123456678", "04/24"
    Then user validates the success message
    Then the user validates product details "MyMoney", "4", "Techtorial", "2200 E Devon", "Des Plaines", "IL", "60018", "Visa", "123456678", "04/24"


  @products @outline
  Scenario Outline: Validation of New Product Creation

    Given the user navigates to product website home page
    When the user enters the product info "<productName>" and "<quantity>"
    Then the user enters the address info "<name>", "<street>", "<city>", "<state>" , "<zipcode>"
    And the user enters the card info "<cardType>", "<cardNumber>", "<expireDate>"
    Then user validates the success message
    Then the user validates product details "<productName>", "<quantity>", "<name>", "<street>", "<city>", "<state>", "<zipcode>", "<cardType>", "<cardNumber>", "<expireDate>"
    Examples:
      | productName | quantity | name  | street       | city        | state | zipcode | cardType         | cardNumber | expireDate |
      | MyMoney     | 4        | David | 2200 E Devon | Des Plaines | IL    | 60018   | Visa             | 123456678  | 04/24      |
      | FamilyAlbum | 2        | Jack  | 2344 N North | Austin      | TX    | 90007   | Master Card      | 123456478  | 08/21      |
      | ScreenSaver | 5        | Laura | 5432 W East  | Chicago     | IL    | 60066   | American Express | 123456658  | 04/22      |
      | FamilyAlbum | 2        | Jack  | 2344 N North | Austin      | TX    | 90007   | Master Card      | 123456478  | 08/21      |
