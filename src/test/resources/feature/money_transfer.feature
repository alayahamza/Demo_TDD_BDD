Feature: money transfer 
	third party money transfer
  
Scenario: transfer money from a user's account to another user's account 

	Given account to transfer from initialised with balance '2300' 
	And   account to transfer to initialised with balance '24200' 
	When  transfer '2100' from first account to the second 
	Then  take transfer fee '2' 