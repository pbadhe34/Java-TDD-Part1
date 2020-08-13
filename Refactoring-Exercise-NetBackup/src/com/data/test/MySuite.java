package com.data.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)

@SuiteClasses(com.data.test.AllTests.class)

public class MySuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.data.test MySuite");
		//$JUnit-BEGIN$
		//suite.addTest(AllTests.suite());
		//$JUnit-END$
		return suite;
	}

}
