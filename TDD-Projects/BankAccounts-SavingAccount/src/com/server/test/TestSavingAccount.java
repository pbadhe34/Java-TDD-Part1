package com.server.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.server.bank.Currency;
import com.server.bank.Dollar;
import com.server.bank.SavingAccount;

 

public class TestSavingAccount 
{
    private SavingAccount obj = new  SavingAccount();	
	 
	public TestSavingAccount()
	{
		System.out.println("TestSavingAccount.constructor..");
		// obj = new SavingAccount();
	}
	
	@Test
	public void testSavingAccountObject()
	{
       Assert.assertNotNull(obj);
        
	}	
	@Test
	public void verifyavingAccountDeposit()
	{
        //SavingAccount obj = new SavingAccount();
        obj.deposit(1200);       //compiler error..Fix it..

	}
	@Test
	public void VerifySavingAccountBalance()
	{
        //SavingAccount obj = new SavingAccount();
        obj.deposit(1200);             
        Assert.assertEquals(1200, obj.getBalance()); //compiler error..Fixed it..
	}
	@Test
	public void VerifySavingAccountMultipleDeposits()
	{
        //SavingAccount obj = new SavingAccount();
        obj.deposit(1000);
        obj.deposit(2400);              
        Assert.assertEquals(3400, obj.getBalance());//verify the final balance
	}
	@Test
	public void testSavingAccountInitBalance()
    {
	  SavingAccount obj = new SavingAccount(1000);//Compiler Error..Fix it      
       
      int amount = obj.getBalance();
     
      Assert.assertEquals(1000, amount);//verify the current  balance
 }
	@Test
	public void testSavingAccountInitBalanceDeposit()
    {
        SavingAccount obj = new SavingAccount(1000);
        obj.deposit(500);
        int amount = obj.getBalance();
        Assert.assertEquals(1500, amount);//verify the current  balance
     }
	@Test
    public void testSavingAccountDollarTransfer()
    {
        obj = new SavingAccount();    
        obj.deposit(1000);
        Currency usCurrency = new Dollar(100);
        obj.deposit(usCurrency);//Compiler Error Fix it
        
        int amount = (int) (usCurrency.getRupeesConvresionRate() * usCurrency.getCurrencyValue());
        
        Assert.assertEquals( 1000+amount, obj.getBalance());//verify the current  balance
    }
	
	@Test
	public void TestSavingAccountWithdraw()
    {
		SavingAccount obj = new SavingAccount(2000);
        obj.withdraw(1000);   
        int amount = obj.getBalance();
        Assert.assertEquals(1000, amount);
    }
	@Test
	public void TestSavingAccountDepositAndWithdraw()
    {
		SavingAccount obj = new SavingAccount();
        obj.deposit(3000);
        
        obj.withdraw(2000);

        int amount = obj.getBalance();
        Assert.assertEquals(1000, amount);
    }
	
	@Test(expected=com.server.bank.WithDrawAmountMoreThanBalance.class)
    public void TestSavingAccountWithdrawMoreAmount()
         {
		    SavingAccount obj = new SavingAccount();
		
             obj.deposit(1000);

             obj.withdraw(3000);

             int amount = obj.getBalance();

             Assert.assertEquals(2000, amount);
         }
    @Before
    public void setUp() throws Exception {
		 
		System.out.println("TestSavingAccount.setUp()");
		obj =  new SavingAccount();
	}
	 @After
	public void tearDown() throws Exception {
		 
		System.out.println("TestSavingAccount.tearDown()");
		obj = null;
	}


}
