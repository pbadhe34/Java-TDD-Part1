package com.simple;

public class Account {
	
	private String branchName;
	public Account()
	{
		System.out.println("Account.Account()");
	}
	
	public Account(String newName)
	{
		name.concat(newName);
	}
	 private int account_no;
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAccount_no(int account_no) {
	    String name;
		this.account_no = account_no;
		 
	}
	private String name;
	 public void update()
	    {
	    	System.out.println("updating the accont");
	    }
	 
	 public void deposit(int amount)
	 {
		 System.out.println("Here deposit in the accont for "+amount);
	 }
	 
/*
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_no;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	} 
	 
	
	//public boolean equals(Object obj) {	
	public boolean equals(Account obj) {
		System.out.println("Account.equals()"); 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (account_no != other.account_no)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
*/

	public int getAccount_no() {
		System.out.println("Account.getAccount_no()");
		return account_no;
	}
	
	private int getNumber()
	{
		System.out.println("Account.getAccount_no()");
		return account_no;
	}
	public static void main(String args[]){
		System.out.println("Account.main testing()");
		Account obj = null;
		System.out.println(obj.getName());
	}
	private int calculateInterest()
	{
		System.out.println("Account.calculateInterest()");
		System.out.println("This is chanage done in accpint class..");
		return 9;
	}
	private String replaceName(String newName)
	{
		name.replace(name, newName);
		return name;
	}
	private String updateAccount(int id,double amount)
	{
		return "Updated with id = "+id;
	}
	 
}
