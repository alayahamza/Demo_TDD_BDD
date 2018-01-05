Feature: minimum balance 
	validate users account for minimum balance.
  
Scenario: validate users accounts for minimum balance. 

	Given  a list of users  
		|1|hamza|hamza@talan|
		|2|mahdi|mahdi@talan|
		|3|achraf|achraf@talan|
	And  a list of users accounts 
		|id|balance|owner|
		|1 |4049   |1	 |
		|2 |5600   |2	 |
		|3 |105528 |3	 |
	When  withdraw money amount '4000' from users accounts if minimum balance is '50' 
	Then all accounts should have minimum balance 