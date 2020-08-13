/**
 * This is first version of test case class
 */
package com.data.test;

 
import org.junit.Test;
import org.junit.Assert;

import com.data.server.BackupManager;
import com.data.server.DifferentialBackupManager;
import com.data.server.IncrementalBackupManager;

 
public class TestIncrementalBackup {
	 
	@Test	 
	public void checkIncrementalFileBackUp() {		 
		System.out
				.println("TestDifferentialBackup.checkDifferentialFileBackUp()");
		IncrementalBackupManager manager = new IncrementalBackupManager();
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
		IncrementalBackupManager manager = new IncrementalBackupManager();
		Assert.assertFalse(manager.backupFile(""));
		Assert.assertFalse(manager.validateFileBackup(""));
		Assert.assertEquals(false, manager.verifyFileBackup(""));		 
	}

	@Test
	public void testIncrementalDirectoryBackup() {
		System.out.println("TestBackupFirst.testDirectoryBackup()");
		IncrementalBackupManager manager = new IncrementalBackupManager();
		Assert.assertTrue(manager.backupDir("D:\\BackupData")); 	
		//boolean flag = manager.validateDirectoryBackup("D:\\BackupData");
		boolean flag = manager.verifyDirectoryContents("D:\\BackupData");
		Assert.assertEquals(true,flag);
	}

}
