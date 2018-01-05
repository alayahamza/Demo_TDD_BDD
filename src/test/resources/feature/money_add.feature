  Feature: money add
  	Credit user account for an amount of money.
  
  Scenario: add money to user account
  
    Given My account set with id '1' ,blance '5000'
	When  add money '2100' to acount with id '1'
	Then take fee '2' from acount with id '1' and new balance is '7098'