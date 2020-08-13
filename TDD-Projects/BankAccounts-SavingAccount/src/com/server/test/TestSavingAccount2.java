package com.server.test;

import junit.framework.Assert;

import org.junit.Test;

import com.server.bank.SavingAccount;

public class TestSavingAccount2 {
	
	/*@Test(expected=com.server.bank.NegativeDepositException.class)
	public void testAccountNegativeDeposit()
	{
		SavingAccount obj = new SavingAccount();
		obj.deposit(-1000);
		 
		int amount = obj.getBalance();
		Assert.assertEquals(10, amount);
	}	 */
	@Test
	public void VerifySavingAccountNegativeBalanceDeposit()
    {
		SavingAccount obj = new SavingAccount(-100);
        obj.deposit(2000);
        int amount = obj.getBalance();
        Assert.assertEquals(0, amount);
    }
	@Test
	public void TestSavingAccountWithdraw()
    {
		SavingAccount obj = new SavingAccount(2000);
        obj.withdraw(1000);  //Compiler Error..Fix It!
        int amount = obj.getBalance();
        Assert.assertEquals(1000, amount);
    }
	
	@Test
	public void TestSavingAccountDepositAndWithdraw()
    {
		SavingAccount obj = new SavingAccount();
        obj.deposit(2000);
        
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





	


}
