package com.app;

import org.app.data.Account;
import org.data.DataBaseException;
import org.data.DataBaseService;

public class BankApp {

	
	 private DataBaseService service;
	 
	 public void setService(DataBaseService service) {
		this.service = service;
	}

	public boolean addAccount(Account data) throws DataBaseException {
		 System.out.println("BankApp.addAccount()");
		 boolean flag = false;
		 
			service.addAccountObject(data);
			flag = true;
		 
		 System.out.println("The accountDB successfully added with "+data.getId()+" name as "+data.getName());
		 return flag;
	 }
	 
	 public String getAccountName(int accountKey) {
		 System.out.println("BankApp.getAccountName()");
		 String accountName = service.readAccountName(accountKey);
		 System.out.println("The accountDB read added with name as "+accountName);
		 return accountName;
	 }
	 
	 public Account readAccountDetails(int id) throws DataBaseException {
		 Account details = service.getAcountObject(id);
		 return details;
	 }
	 
}
