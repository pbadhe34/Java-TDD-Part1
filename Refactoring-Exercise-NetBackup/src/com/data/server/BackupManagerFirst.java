package com.data.server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BackupManagerFirst {
	

	public String getRepositoryPath() {
		 
		String repositoryPath = "D:/BackupData/";
		return repositoryPath;
	}
	 
	public boolean validateSourceFile(String file) {
		File srcFile = new File(file);
		String fname = srcFile.getName(); 
		 
		if (srcFile.exists())
			return true;
		else
			return false;

	}

	public boolean BackupFile(String fileName) {
		   String repositoryPath = "D:/BackupData/"; 
		   File srcFile = new File(fileName);	
		   if(srcFile.exists())
		   {
			String srcName = srcFile.getName();
			// real file backup code			 
			File destFile = new File(repositoryPath + srcName);	
			// Use bytes stream to support all file types
			InputStream inFile = null;
			OutputStream out = null;
			try {
				inFile = new FileInputStream(srcFile);
				out = new FileOutputStream(destFile);

				int bytes = inFile.available();

				byte[] buffer = new byte[bytes];

				int length;
				// copy the file content in bytes
				while ((length = inFile.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}				
				inFile.close();
				out.close();
			} catch (Exception e) {		
				System.out.println("Exception in file backup is  "+e);				 		
			}			
			return true;
		   }
		   else return false;
			   
		}

	public boolean ValidateFileBackup(String file) {
		 //Check if the file exist at  the destination..
		String repositoryPath = "D:/BackupData/";
		File backupfile = new File(file);
		String fname = backupfile.getName(); 		
		File destinationFile = new File(repositoryPath + fname);
		 
		if (destinationFile.exists())
			return true;
		else
			return false;	
		 
	}

	public boolean VerifyBackupFileContents(String fileName) {
	
		String repositoryPath = "D:/BackupData/";
		boolean success = false;
		if (fileName.isEmpty())
			return success;

		File srcFile = new File(fileName);

		// read the file contents and size
		String fname = srcFile.getName();
		 
		 
	    String  fPath = srcFile.getPath();
	    String relPath =fPath.substring(3,fPath.length()); 		 
	//	File destFile = new File(repositoryPath + relPath);		 
		File destFile = new File(repositoryPath + fname);	
		
		DataInputStream dStream = null;
		DataInputStream srcStream = null;
		FileInputStream fis = null;
		FileInputStream fos = null;
		byte contents[] = null;
		byte outContents[] = null;

		int size1 = 0;
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileInputStream(destFile);
			size1 = fis.available();
			int size2 = fos.available();			 
			
				if(size1 !=size2)
				{
					System.out.println("The source and destination  file size in compareFileContents donot match...");
					return success;
				}

			dStream = new DataInputStream(new FileInputStream(destFile));			 

			srcStream = new DataInputStream(fis);			 

			contents = new byte[size1];
			outContents = new byte[size2];			 
			srcStream.read(contents);
			dStream.read(outContents);	
		
		int index = 0;
		success = true;

		for (byte b : outContents)
		{

			if (b == contents[index]) 
			{				 
				index++;
				continue;
			} else
			{
				success = false;
				 System.out.println("The contents donot match..");
				break;
			}

		}
	} catch (Exception e)
		{
			System.out.println("The error in compareFileContents is " + e.getMessage());
			success = false;
		}
		return success;				 
	}

	public boolean backupDirectory(String string) {
		 
		return true;
	}

	 

	 

}
