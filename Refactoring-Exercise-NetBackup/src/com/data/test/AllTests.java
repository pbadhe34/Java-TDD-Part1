package com.data.test;

import org.junit.runners.Suite;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

 

@SuiteClasses({ com.data.test.TestBackupOne.class, com.data.test.UserTest.class, com.data.test.TestBackupTwo.class,
		com.data.test.TestBackupThree.class, com.data.test.TestDifferentialBackup.class,
		com.data.test.TestIncrementalBackup.class })

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.data.test AllTests");
		// $JUnit-BEGIN$

		// $JUnit-END$

		return suite;
	}

}
