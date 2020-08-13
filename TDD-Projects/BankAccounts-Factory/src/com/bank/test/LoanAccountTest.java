/**
 * 
 */
package com.bank.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.bank.mybank.LoanAccount;

/**
 * @author admin
 *
 */
public class LoanAccountTest {

	@Test
	public void testLoanAccountDeposit()
	{
		LoanAccount la = new LoanAccount(12000);
		la.deposit(1000);
		Assert.assertEquals(11000, la.getBalance());
		
	}
	
	@Test
	public void testLoanAccountWithDraw()
	{
		LoanAccount la = new LoanAccount(10000);
		la.withDraw(1000);
		Assert.assertEquals(9000, la.getBalance());
		
	}
	@Ignore
	public void testCheckDues()
	{
		
	}
	
	
}
