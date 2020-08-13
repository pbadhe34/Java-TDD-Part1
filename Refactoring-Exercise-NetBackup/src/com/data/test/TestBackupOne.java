package com.data.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.data.server.BackupManager;
 

public class TestBackupOne {
	
	@Test
	public void VerifyBackupManagerCreateObject()
	{
        BackupManager obj = new BackupManager();
        assertNotNull(obj);

	}
	
	@Test
	public void VerifyBackupManagerRepositortyPath()
	{
        BackupManager obj = new BackupManager();       
        
        String expectedPath = "D:/BackupData/";  
        
        String backupPath = obj.getRepositoryPath();
        //Compiler error..Fix It    

        assertEquals(expectedPath, backupPath);

	}	
	@Test
	public void TestBackupManagerValidateFile()
	{
        BackupManager obj = new BackupManager();
        String file = "C:/source/message.txt";
        boolean result = obj.validateSourceFile(file);
        //Compiler error..Fix It       

        assertTrue(result);

	}
	@Test
	public void VerifyBackupManagerBackupFile()
	{
        BackupManager obj = new BackupManager();
        boolean result = obj.backupFile("C:/source/message.txt");       

         assertTrue(result);

	}
	
	@Test
	public void VerifyBackupManagerValidateFileBackup()
	{
        BackupManager obj = new BackupManager();
        String file = "C:/source/message.txt";
        
        boolean result = obj.backupFile("C:/source/message.txt");       
        
        result = obj.validateFileBackup(file);
        //Compiler error..Fix It       

        assertTrue(result);

	}
	@Test
    public void TestBackupManagerEmptyFileNameBackup()
	{
		BackupManager obj = new BackupManager();
		boolean result = obj.backupFile("");
        assertFalse(result);         

	}
	
	@Test
    public void TestNonExistingFileBackup()
	{
		BackupManager obj = new BackupManager();
		boolean result = obj.backupFile("C:/source/admin.txt");       
        assertFalse(result);     
     }
	 
	@Test
    public void TestVerifyBackupFileContents()
	{
		BackupManager obj = new BackupManager();
		obj.backupFile("C:/source/message.txt");    
		boolean result = obj.VerifyBackupFileContents("C:/source/message.txt");   //Compiler error..Fix it..    
        assertTrue(result);       

	}
	
    
	@Test
    public void TestValidateDirectoryBackup()
	{
		BackupManager obj = new BackupManager();
		boolean result = obj.backupDir("C:\\source");
        obj.validateFileBackup("C:\\source");		 
        assertTrue(result);       

	}
	@Test
    public void VerifyValidateDirectoryBackupContents()
	{
		BackupManager obj = new BackupManager();
		boolean result = obj.backupDir("C:\\source");
        obj.verifyDirectoryContents("C:\\source");		 
        assertTrue(result);       

	}

	

}
