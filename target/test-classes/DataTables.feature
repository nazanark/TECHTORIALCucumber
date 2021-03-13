Feature: Data Table Practice

  Scenario: Type of Data Tables
    Given the user prints products title
      | Product:*       |
      | Quantity:*      |
      | Price per unit: |
      | Discount:       |
      | Total:          |
    When user prints credentials
      | username | Tester |
      | password | test   |
    Then the user print product info
      | MyMoney     | 4 | Techtorial | 2200 E Devon | Chicago |
      | FamilyAlbum | 2 | Academy    | 2200 E Devon | Austin  |
    * the user print product details
      | Product     | Q | Name       | Street       | City    |
      | MyMoney     | 4 | Techtorial | 2200 E Devon | Chicago |
      | FamilyAlbum | 2 | Academy    | 2200 E Devon | Austin  |