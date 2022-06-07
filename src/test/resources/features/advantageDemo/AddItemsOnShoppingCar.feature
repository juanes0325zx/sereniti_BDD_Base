Feature: AddItemsOnShoppingCar


  Scenario Outline: Add Items On Shopping Car and navigate to checkout

    Given I login with user. i user row data "<row>" Actor "<Actor>"
    And I Navegate To Laptop category
    When  I select one item of laptop category "<row>"
    Then I validate Name of item vs checkout



    Examples:
      | row | Actor  |
      | 0   | user 1 |
      | 1   | user 2 |
      | 2   | user 3 |
      | 3   | user 4 |
      | 4   | user 5 |



