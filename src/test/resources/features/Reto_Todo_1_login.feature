Feature: login_to_saucedemo


  Scenario Outline: Todo_1 login


   Given login whit user "<row>" "<Actor>"
   And  Add Product to shopin car
   When  Fill from with FirstName LastName and region code "<row>"
   Then  Validate complete checkout



   Examples:
     | row | Actor  |
     | 0   | user 1 |
     | 3   | user 2 |
     | 2   | user 3 |








