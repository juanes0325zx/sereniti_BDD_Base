Feature: login_to_saucedemo


  Scenario Outline: Todo_1 login


   Given login whit  valid user "<row>" "<Actor>"
   When  Load data for validate
   Then  Validate login with valid user



   Examples:
     | row | Actor  |
     | 0   | user 1 |
     | 3   | user 2 |
     | 2   | user 3 |








