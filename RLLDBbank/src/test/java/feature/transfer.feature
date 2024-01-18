Feature: Enter Acounts and amount for transfer amount

  Scenario Outline: Test amount transfer or not 
    Given I am on signin page
    Then  i will sign in with valid credentials
    Then  i click on  the  transfer amount page
    Then  i will select the from account  
    And i will select the to account  
    And I enter amount as '<Amount>' on the page
    Then I click submit button
      When amount unsuccesfully transfer 
   
   
    

    Examples: 
      | Amount | 
      | 1 |    
      |3000|
      |0|
      |10000|
      |   -100|
      | |