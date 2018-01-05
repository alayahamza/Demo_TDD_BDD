  Feature: money withdraw
  	Debit user account for an amount of money.
  
  Scenario: withdraw money from account
  
    Given user account initialized with id '1' , blance '5000'
	When  withdraw money amount '6500' from acount with id '1'
	Then validate acount with id '1'  new balance is '5000'