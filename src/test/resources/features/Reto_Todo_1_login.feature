Feature: login_to_saucedemo


  Scenario Outline: Todo_1 login


   Given "<User>" login whit old user "<password>"
   And  Add Product to shopin car
   When  Fill from with FirstName "<firstname>", LastName "<lastname>" and region code "<code>"
   Then  pendiente validar



   Examples:
    | lastname | firstname | code  | User          | password     |
    | montoya  | jhon      | 21615 | standard_user | secret_sauce |







