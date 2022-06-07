Feature: Register_New_User


  Scenario Outline: Register random New User



    Given I register whit new user. i user row data "<row>" Actor "<Actor>"
    When  I fill data of new user and register "<row>"
    Then  Validate complete register



    Examples:
      | row | Actor  |
      | 0   | user 1 |
      | 1   | user 2 |
      | 2   | user 3 |
      | 3   | user 4 |
      | 4   | user 5 |