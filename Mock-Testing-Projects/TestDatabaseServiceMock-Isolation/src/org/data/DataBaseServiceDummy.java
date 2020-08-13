package org.data;

import org.app.data.Account;

public class DataBaseServiceDummy implements DataBaseService {
	
	public static int calculateAccountID() {
		System.out.println("DatBaseServiceDummy calculateAccountID()");
		return 4567;
	}

	@Override
	public void addAccountObject(Account obj) throws DataBaseException {
		System.out.println("DaatBaseServiceDummy.addAccountObject()");
		//int dataId = calculateAccountID();
		obj.setId(4567);
	}

	@Override
	public String readAccountName(int id) {
		//empty
		return null;
	}

	@Override
	public boolean updateAccountBalance(int id, double amount) {
		//empty
		return false;
	}

	@Override
	public boolean updateAccountName(int id, String accountName) {
		//empty
		return false;
	}

	@Override
	public Account getAcountObject(int idKey) throws DataBaseException {
		//empty
		return null;
	}

}
