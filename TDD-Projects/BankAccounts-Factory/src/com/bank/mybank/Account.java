package com.bank.mybank;

public abstract class Account {

	protected int balance; 

	public abstract void deposit(int amount);
	public abstract void withDraw(int amount);

	protected boolean checkValid() {
		if(balance < 0)	
		{
			System.out.println("The account is InValid. canNot depsoit");
			return false;
		}
		else
			return true;
	}
	 public int getBalance() {
			return balance;
		}

}