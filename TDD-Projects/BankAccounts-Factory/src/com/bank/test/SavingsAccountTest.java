package com.bank.test;

import org.junit.Assert;
import org.junit.Test;

import com.bank.mybank.SavingsAccount;

public class SavingsAccountTest {
	
	@Test
	public void testSavingAccountDeposit()
	{
		SavingsAccount obj = new SavingsAccount(0);
		 
		
		obj.deposit(1000);
		Assert.assertEquals(1000, obj.getBalance());
		
		obj.deposit(1000);
		Assert.assertEquals(2000, obj.getBalance());		 
		 
	}
	
	@Test
	public void testInvalidAccountDeposit()
	{
		SavingsAccount obj2 = new SavingsAccount(-1000);		 
		
		obj2.deposit(500);
		Assert.assertEquals(-1000, obj2.getBalance());		
		 
	}
	@Test
	
	 public void testWithDrawAccount()
	 {
        SavingsAccount obj = new SavingsAccount(10000);
		obj.withDraw(5000);	 
		
		Assert.assertEquals(5000, obj.getBalance());
		
        SavingsAccount obj2 = new SavingsAccount(-1000);		 
		
		obj2.withDraw(500);
		Assert.assertEquals(-1000, obj2.getBalance());	
	 }
	
	@Test
	
	 public void testInvalidAccountWithDraw()
	 {       
        SavingsAccount obj2 = new SavingsAccount(-1000);	 
		
		obj2.withDraw(500);
		Assert.assertEquals(-1000, obj2.getBalance());	
	 }
	
	
	 

}
