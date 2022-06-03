Feature: login_to_saucedemo


  Scenario Outline: Todo_1 login


   Given login whit user "<row>"
   And  Add Product to shopin car
   When  Fill from with FirstName LastName and region code "<row>"
   Then  Validate complete checkout



   Examples:
     | row |
     | 0   |
     | 2   |
     | 3   |








