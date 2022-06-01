Feature: login_to_saucedemo


  Scenario Outline: Todo_1 login


   Given "<User>" login whit old user "<password>"
   When "<Product>" select product, user "<firstname>" "<lastname>" region code "<code>"
   Then  pendiente validar



   Examples:
    | Product | lastname | firstname | code   | User          | password     |
    | fsdfds  | sadfasdf | sadfasdf  | dsfafd | standard_user | secret_sauce |
   






