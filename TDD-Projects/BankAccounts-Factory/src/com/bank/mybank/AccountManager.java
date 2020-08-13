package com.bank.mybank;

import com.bank.mybank.AccountType.accountType;
 
public class AccountManager {
	static Account accountObject = null;

	public static Account getAccount(accountType acType,int initialAmount) {
		 
		switch(acType)
		 {
		 case  Loan:
			 accountObject = new LoanAccount(initialAmount);
			 break;
			  
		 case  Savings:
			 accountObject = new SavingsAccount(initialAmount);	
			  break;
		default :
			accountObject = null;			  
			 
		 }
		return accountObject;
	}

}
