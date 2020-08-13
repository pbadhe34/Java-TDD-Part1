/**
 * 
 */
package com.bank.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.bank.mybank.Account;
import com.bank.mybank.AccountType.accountType;
import com.bank.mybank.AccountManager; 

/**
 * @author admin
 *
 */
public class TestAccounts {

	@Test
	public void testLoanAccountDeposit()
	{
		
		Account acObject =  AccountManager.getAccount(accountType.Loan,12000);
		 acObject.deposit(1000);
		Assert.assertEquals(11000, acObject.getBalance());
		
	}
	
	@Test
	public void testLoanAccountWithDraw()
	{
		Account acObject =  AccountManager.getAccount(accountType.Loan,10000);
		
		acObject.withDraw(1000);
		Assert.assertEquals(9000, acObject.getBalance());
		
	}
	@Ignore
	public void testCheckDues()
	{
		
	}
	
	@Test
	public void testSavingAccountDeposit()
	{
		Account acObject =  AccountManager.getAccount(accountType.Savings,1000);
		 	
		acObject.deposit(1000);
		Assert.assertEquals(2000, acObject.getBalance());
		
		acObject.deposit(1000);
		Assert.assertEquals(3000, acObject.getBalance());		 
		 
	}
	
	@Test
	public void testInvalidAccountDeposit()
	{
		Account acObject =  AccountManager.getAccount(accountType.Savings,-1000);
				
		acObject.deposit(500);
		Assert.assertEquals(-1000, acObject.getBalance());		
		 
	}
	@Test	
	 public void testWithDrawAccount()
	 {
        
    	Account obj =  AccountManager.getAccount(accountType.Savings,10000);
    	
		obj.withDraw(5000);	 
		
		Assert.assertEquals(5000, obj.getBalance());
		
        obj =  AccountManager.getAccount(accountType.Savings,-1000);		 
		
		obj.withDraw(500);
		Assert.assertEquals(-1000, obj.getBalance());	
	 }
	
	@Test	
	 public void testInvalidAccountWithDraw()
	 {       
		Account obj =  AccountManager.getAccount(accountType.Savings,-1000);
    		 
		obj.withDraw(500);
		Assert.assertEquals(-1000, obj.getBalance());	
	 }
	
	
	 
	
	
}
