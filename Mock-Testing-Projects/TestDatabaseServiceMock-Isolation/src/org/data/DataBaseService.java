package org.data;

import org.app.data.Account;

public interface DataBaseService {
	
	public void addAccountObject(Account obj)throws DataBaseException;	
	public String readAccountName(int id);	
	public boolean updateAccountBalance(int id,double amount);
	public boolean updateAccountName(int id,String accountName);
	public Account getAcountObject(int idKey)throws DataBaseException;
	

}
