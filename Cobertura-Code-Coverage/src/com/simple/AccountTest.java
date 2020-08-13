package com.simple;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

 

public class AccountTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAccount_no() {
		System.out.println("implemented in accountTest");
		Account ac = new Account();
		int no = ac.getAccount_no();
		Assert.assertEquals(0, no);
	}
	
	@Test
	public void testAccountEquals() {
		 
		Object ac1 = new Account();
		/*ac1.setAccount_no(123);
		ac1.setName("Ashok");
		*/
		Account ac2 = new Account();
		ac2.setAccount_no(123);
		ac2.setName("Vijay");
		
		// ac1 = ac2;		
		 
		
		
		boolean result = ac1.equals(ac2);
		Assert.assertEquals(false, result);
	}
	
	public void testNoTests() {
		
	 System.out.println("AccountTest.testNoTests()");
	}
		 

}
