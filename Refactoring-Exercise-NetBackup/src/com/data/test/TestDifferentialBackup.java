/**
 * This is first version of test case class
 */
package com.data.test;

 
import org.junit.Test;
import org.junit.Assert;

import com.data.server.BackupManager;
import com.data.server.DifferentialBackupManager;

 
public class TestDifferentialBackup {
	 
	@Test	 
	public void checkDifferentialFileBackUp() {		 
		System.out
				.println("TestDifferentialBackup.checkDifferentialFileBackUp()");
		DifferentialBackupManager manager = new DifferentialBackupManager();
		Assert.assertTrue(manager.backupFile("C:\\source\\message.txt"));
		 
		Assert.assertEquals(true,
				manager.validateFileBackup("C:\\source\\message.txt"));

		Assert.assertEquals(true,
				manager.verifyFileBackup("C:\\source\\message.txt"));	 

	}
	@Test
	public void checkEmpyFileNameBackup()
	{
		System.out.println("TestBackupFirst.checkEmpyFileNameBackup()");
		DifferentialBackupManager manager = new DifferentialBackupManager();
		Assert.assertFalse(manager.backupFile(""));
		Assert.assertFalse(manager.validateFileBackup(""));
		Assert.assertEquals(false, manager.verifyFileBackup(""));		 
	}

	@Test
	public void testDirectoryBackup() {
		System.out.println("TestBackupFirst.testDirectoryBackup()");
		DifferentialBackupManager manager = new DifferentialBackupManager();
		Assert.assertTrue(manager.backupDir("C:\\source")); 	
		//boolean flag = manager.validateDirectoryBackup("C:\\source");
		boolean flag = manager.verifyDirectoryContents("C:\\source");
		Assert.assertEquals(true,flag);
	}

}
