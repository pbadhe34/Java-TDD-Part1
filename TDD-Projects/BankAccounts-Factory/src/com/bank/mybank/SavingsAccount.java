/**
 * 
 */
package com.bank.mybank;

/**
 * @author admin
 *
 */
public class SavingsAccount extends Account {
	public SavingsAccount(int initBalance)
	{
		balance = initBalance;
	}
	
	public void deposit(int amount) {
		 if(checkValid())	 	  
		  
	       balance += amount;
	}
	public void withDraw(int amount)
	 {
		         if(!checkValid())	
		        	 return;
		         if(amount < balance)		        	 
				   balance -= amount;
	 } 
	 
	 
	 

}
