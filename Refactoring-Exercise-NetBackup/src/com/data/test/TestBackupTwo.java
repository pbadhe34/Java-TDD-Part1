 
package com.data.test;

 
import org.junit.Test;
import org.junit.Assert;

import com.data.server.BackupManager;

 
public class TestBackupTwo {
	 
	@Test	 
	public void testFileBackUp() {		 
		System.out.println("TestBackupFirst.testFileBackUp()");
		BackupManager manager = new BackupManager();
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
		System.out.println("TestBackupFirst.checkEmpyFileNameBackup()");
		BackupManager manager = new BackupManager();
		Assert.assertFalse(manager.backupFile(""));
		Assert.assertFalse(manager.validateFileBackup(""));
		Assert.assertEquals(false, manager.verifyFileBackup(""));		 
	}

	@Test
	public void testDirectoryBackup() {
		System.out.println("TestBackupFirst.testDirectoryBackup()");
		BackupManager manager = new BackupManager();
		Assert.assertTrue(manager.backupDir("C:\\source")); 	
		//boolean flag = manager.validateDirectoryBackup("C:\\source");
		boolean flag = manager.verifyDirectoryContents("C:\\source");
		Assert.assertEquals(true,flag);
	}

}
