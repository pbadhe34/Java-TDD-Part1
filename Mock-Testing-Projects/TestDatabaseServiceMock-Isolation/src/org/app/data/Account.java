package org.app.data;

public class Account {

	private int id;
	private String name;
	private double balance;
	
	public Account() {
		
	}
	
   public Account(int idNew,double newBalance) {
	id = idNew;
	balance = newBalance;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
