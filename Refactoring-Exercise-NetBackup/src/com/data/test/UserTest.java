package com.data.test;

import junit.framework.Assert;

import org.junit.Test;

import com.data.server.User;

public class UserTest {
	@Test(expected=java.lang.Exception.class)
	//@Test(timeout=1200,expected=java.lang.Exception.class)
	 public void testUserLogin() throws Exception
	 {
	  User user = new User();
	  user.login("","Narang");
	 //Assert.assertEquals(false, user.getResult());
	 }
	@Test	 
	 public void testValidUserLogin() throws Exception
	 {
	  User user = new User();
	  user.login("DON","Narang");
	  Assert.assertEquals(false, user.getResult());
	 }

}
