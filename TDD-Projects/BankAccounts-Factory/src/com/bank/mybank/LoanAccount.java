/**
 * 
 */
package com.bank.mybank;

/**
 * @author admin
 *
 */
public class LoanAccount extends Account {
	public LoanAccount(int initAmount)
	{
		balance = initAmount;
	}
	
	public void deposit(int amount)
	{
		 if(checkValid())	 	  
		  
	       balance -= amount;
	}

	 

	 
	public void withDraw(int amount) {
		if(!checkValid())	
       	 return;
		 int balAmount = balance - amount;
		 if(balAmount > 100)
			 balance -= amount;
			 
		
	}
	 
	 
	  
	 

}
