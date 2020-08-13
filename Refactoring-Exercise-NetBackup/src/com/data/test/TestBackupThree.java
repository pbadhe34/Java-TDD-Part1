/**
 * 
 */
package com.data.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

import com.data.server.BackupManager;

/**
 * @author admin
 * 
 */
public class TestBackupThree {
	private BackupManager manager;
	
	public TestBackupThree()
	{
		System.out.println("TestBackupSecond.constructor..()");
		manager = new BackupManager();		
	}
	
	@BeforeClass
	public static void TestBackup()
	{
		System.out.println("TestBackupSecond.initClass()");
	}
	
	@AfterClass
	public static void closeTestBackup()
	{
		System.out.println("TestBackupSecond.afer class()");
	}
		
	@Before
	public void initSetUp()
	{
		System.out.println("TestBackupSecond.initSetUp()"); 	
	}
	
	@After
	public void tearDown()
	{
		System.out.println("TestBackupSecond.tearDown()"); 
	}

	@Test	 
	public void testFileBackUp() {		 
			System.out.println("TestBackupSecond.testFileBackUp()");		 
			Assert.assertTrue(manager.backupFile("C:\\source\\message.txt"));
		// Assert.assertTrue(manager.validateBackup("C:\\source\\message.txt"));
		Assert.assertEquals(true,
				manager.validateFileBackup("C:\\source\\message.txt"));

		Assert.assertEquals(true,
				manager.verifyFileBackup("C:\\source\\message.txt"));	
	}
	@Test
	public void checkEmpyFileNameBackup()
	{
		System.out.println("TestBackupSecond.checkEmpyFileNameBackup()");		 
		Assert.assertFalse(manager.backupFile("")); 
		Assert.assertFalse(manager.validateFileBackup(""));
		Assert.assertEquals(false, manager.verifyFileContents(""));		 
	}

	@Test
	public void testDirectoryBackup() {
		System.out.println("TestBackupSecond.testDirectoryBackup()");		  
		Assert.assertTrue(manager.backupDir("D:\\BackupData")); 	
		boolean flag = manager.verifyDirectoryContents("D:\\BackupData");
		Assert.assertEquals(true,flag);
	}
	 

}
