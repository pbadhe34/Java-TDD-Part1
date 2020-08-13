package com.server.bank;

public class SavingAccount {
	
	private int balance;

	public void deposit(int amount) {			
		balance+= amount;	
		 
	}
	
   public void deposit(Currency currency) {	
		double amount = currency.getRupeesConvresionRate() * currency.getCurrencyValue();
		balance+= amount;		
		 
	}

	  public int  getBalance()
        {
            /*if (balance < 0)
                balance = 0;*/
            return balance;
        }	 	
 
	public SavingAccount(int amount)
    {
        this.balance = amount;
    }
    //default constructor
    public SavingAccount()
    {
       // this.balance =1000;
    } 
    public void withdraw(int amount)
    {      
        if(amount  >  balance )
        { 
           throw new WithDrawAmountMoreThanBalance("More amount withdrawn");
        }
                	
      	 //obvious implementation
    	  balance-= amount;
    	 
    }


}
