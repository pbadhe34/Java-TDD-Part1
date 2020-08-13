/**
 * 
 */
package com.data.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * @author admin
 * This is the normal backup manager class
 */
public class BackupManager {
	private String repositoryPath = "D:/BackupData/";
	private boolean success = false;
	
	public String getRepositoryPath() {
		 
		return repositoryPath;
	}

	public boolean backupFile(String fileName) {
		 
		File srcFile = new File(fileName);
		if (srcFile.exists())
		{
			// real file backup code
			String fname = srcFile.getName();
			System.out.println("The source file name is  " + srcFile.getName());
			System.out.println("The source file absolute path  is  "+ srcFile.getAbsolutePath());		 
			
			File destFile = new File(repositoryPath + fname);
			System.out.println("The destination file path is  "
					+ destFile.getAbsolutePath());
			try 
			{
				copyFileContents(srcFile,destFile);
			} catch (IOException e) {
				System.out.println("Error in copyFileContents "
						+ e.getMessage());
			}	
			success = true;
		} else 
		{
			System.out.println("The source file  " + fileName
					+ " doesnot Exist! ");
			success = false;
		}
		return success;
	}

	public boolean validateFileBackup(String fileName) {
		if (fileName.isEmpty())
			return false;
		File srcFile = new File(fileName);
		String fname = srcFile.getName();

		File backedFile = new File(repositoryPath + fname);
		System.out.println("The backed file name in validateFileBackup is  "
				+ backedFile.getName());
		System.out.println("The backed file path in validateFileBackup is  "
				+ backedFile.getAbsolutePath());
		if (backedFile.exists())
			return true;
		else
			return false;
	}
	public boolean verifyFileBackup(String fileName)
	{
		 
		if (fileName.isEmpty())
			return false;

		File srcFile = new File(fileName);

		// read the file contents and size
		String fname = srcFile.getName();	     
		 
		System.out.println("The source file name in verifyFileBackup is  " + srcFile.getName());
		System.out.println("The source file path in verifyFileBackup is  "
				+ fname);		 

		File destFile = new File(repositoryPath + fname);
		System.out.println("The destFile file path in verifyFileBackup is  "
				+ destFile.getAbsolutePath());
		
		
		boolean flag = compareFileContents(srcFile,destFile);
		return flag;
	}

	public boolean verifyFileContents(String fileName) {
		success = false;
		if (fileName.isEmpty())
			return success;

		File srcFile = new File(fileName);

		// read the file contents and size
		String fname = srcFile.getName();
		String fPath = null;
		 
	    fPath = srcFile.getPath();
	    String relPath =fPath.substring(3,fPath.length());
		 
		System.out.println("The source file name in verifyFileContents is  " + srcFile.getName());
		System.out.println("The source file path in verifyFileContents is  "
				+ fPath);
		System.out.println("The source file relative path in verifyFileContents is  "
				+ relPath);

		File destFile = new File(repositoryPath + relPath);
		System.out.println("The destFile file path in verifyFileContents is  "
				+ destFile.getAbsolutePath());
		
		boolean flag = compareFileContents(srcFile,destFile);
		return flag;
	}
	
	private boolean compareFileContents(File srcFile,File destFile)
	{  
		success = false;
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

			System.out
					.println("The src file size in compareFileContents  method is  " + size1);
			System.out.println("The dest file size in compareFileContents  method is  "
					+ size2);
			
			if(size1 !=size2)
			{
				System.out.println("The source and destination  file size in compareFileContents donot match...");
				return success;
			}

			dStream = new DataInputStream(new FileInputStream(destFile));			 

			srcStream = new DataInputStream(fis);
			 

			contents = new byte[size1];
			outContents = new byte[size2];

			System.out.println("Loading the files conetnts..");
			srcStream.read(contents);

			dStream.read(outContents);	
		
		int index = 0;
		success = true;

		for (byte b : outContents)
		{

			if (b == contents[index]) {
				//System.out.println("Comparing the contents..");
				index++;
				continue;
			} else {
				success = false;
				System.out.println("The contents donot match..");
				break;
			}

		}
		} catch (Exception e)
		{
			System.out.println("The error in compareFileContents is " + e.getMessage());
		}
		return success;

	}

	public boolean backupDir(String dirPath) {

		File srcDir = new File(dirPath);
		if (srcDir.exists() == false) {
			System.out.println("The source directory  " + dirPath
					+ " doesnot Exist! ");
			return false;
		}

		if (srcDir.isDirectory() == false) {
			System.out.println("The source is not the directory!");
			return false;
		}

		String pname = srcDir.getName();

		File backDir = new File(repositoryPath + pname);

		if (!backDir.exists())
			backDir.mkdir();

		try {
			copyFileContents(srcDir, backDir);
		} catch (IOException e) {
			System.out.println("The error in copy  dir contents is  "
					+ e.getMessage());
		}
		return true;
	}

	private void copyFileContents(File src, File dest) throws IOException {

		if (src.isDirectory()) {

			// if destination directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
				System.out.println("Directory contents copying from " + src
						+ "  to " + dest);
			}
			// list the src directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structures
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFileContents(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			int bytes = in.available();

			byte[] buffer = new byte[bytes];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			System.out.println("File copied from " + src + " to " + dest);
		}
	}
	public boolean verifyDirectoryContents(String dirName) {

		success = false;
		if (dirName.isEmpty())
			return success;

		File srcDir = new File(dirName);
		// read the file contents
		String fname = srcDir.getName();
		System.out.println("The dir name in verifyDirectoryContents is  " + srcDir.getName());
		//System.out.println("The source dir path in verifyDirectoryContents is  "
				//+ srcDir.getAbsolutePath());

		File backDir = new File(repositoryPath + fname);
		System.out.println("The backed dir path in verifyDirectoryContents is  "
				+ backDir.getAbsolutePath());
		
		if(backDir.exists()== false)
			return false;	
		 
	    if(backDir.isDirectory())
	    {
	    	if(validateDirectoryBackup(dirName)==false)
	    	   return false;
	    	
	    	String files[] = srcDir.list();
			 
			 
			for (String file : files) {
				// construct the src and dest file structures
				File srcFile = new File(srcDir, file);
				File destFile = new File(backDir, file);
				String filename = srcFile.getPath();
				System.out.println("The src file in verifyDirectoryContents is  "+filename);
				// recursive check
				if(srcFile.isFile())
				{
				  if(verifyFileContents(filename)==false)
				  {
					  System.out.println("The file contents in verifyDirectoryContents valid false for "+filename);					   
					  return false;
				  }
				}
				/*if(srcFile.isDirectory())
				{
					 System.out.println("***Checking the sub directories..");	 
						
					//validate the sub directories and files
					if(verifyDirectoryContents(filename)==false)
						return false;
				}*/
			}
	    	
	    }				 
		 
		return true;
	}
	
	private boolean validateDirectoryBackup(String dirPath) {
		System.out.println("BackupManager.validateDirectoryBackup()");
	    boolean flag = false;
		if (dirPath.isEmpty())
			return flag;
		File sourceFile = new File(dirPath);
		String fname = sourceFile.getName();

		File backedFile = new File(repositoryPath + fname);
		System.out.println("The backed dir name in validateDirectoryBackup is  "
				+ backedFile.getName());
		System.out.println("The backed dir path in validateDirectoryBackup is  "
				+ backedFile.getAbsolutePath());
		if (backedFile.exists()==false) {
			System.out.println("The backed dir path in validateDirectoryBackup doesnot exist");
			return flag;
		}
		else
		{
			System.out.println("validating the dir contents..");
			String srcFiles[] = sourceFile.list();
			//String destFiles[] = backedFile.list();
			flag = true;
			for (String sfile : srcFiles) {
				// construct the src and dest file structures
				File file1 = new File(sourceFile, sfile);
				File file2 = new File(backedFile, sfile);
				// recursive check for dir type
				if(file1.isDirectory())
				{
				  if(validateDirs(file1, file2)== false)
				  {
					  System.out.println("Dir validateBackup  false for "+file1);					  
				      return false;
				  }
				 
				}
			}
			return flag;
		}
		 
	}
	private boolean validateDirs(File src, File dest)
	{
		System.out.println("BackupManager.validateDirs()");
		success = true;		 
			// check if destination is not the directory type
			if (!dest.isDirectory()) {
				 
				System.out.println("The destination directory doesnot exist ");
				return false;
			}
			//list the src directory contents
			String files[] = src.list();
			//String destFiles[] = dest.list();
			 
			for (String file : files) {
				// construct the src and dest file structures
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive check
				if(srcFile.isDirectory())
				{
				  if(validateDirs(srcFile, destFile)==false)
				  {
					  System.out.println("Dir valid false for "+srcFile);					   
					  return false;
				  }
				}
			}

		  		 
		return true;
	}
	private void listContents(String dirPath) {

		String[] fileNames = null;
		try {
			File pathName = new File(dirPath);

			if (pathName.isDirectory()) {
				System.out.println("Backing up the dir  " + dirPath);
				System.out.println("\n$$The Directory contents for ..."
						+ pathName);
				String path = pathName.getPath();
				// System.out.println("The directory path is  "+path);

				fileNames = pathName.list();
				int size = fileNames.length;
				if (size == 0) {
					System.out.println("--The directory  " + pathName
							+ "  is empty...\n");
					return;
				}

				for (int i = 0; i < fileNames.length; i++) {
					// System.out.println("The directory content next is  "+fileNames[i]);
					File file = new File(path, fileNames[i]);
					if (file.isDirectory()) {
						String innerPath = file.getCanonicalPath();
						System.out
								.println("---The directory  contains another directory ..."
										+ innerPath);
						backupDir(innerPath);

					} else {
						System.out
								.println("------The directory contains the file..."
										+ file.getName());

					}

				}

			} else {
				System.out.println("It is the file  " + pathName
						+ "  to be backed up..");
				backupFile(dirPath);
			}

		} catch (Exception e) {
			System.out.println("The error in copy  dir contents is  "
					+ e.getMessage());
		}

	}

	

	public boolean validateSourceFile(String file) {
		File srcFile = new File(file);
		String fname = srcFile.getName(); 
		 
		if (srcFile.exists())
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

}
