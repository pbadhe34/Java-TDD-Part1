package com.server.bank;

public class WithDrawAmountMoreThanBalance extends RuntimeException {
 
	public WithDrawAmountMoreThanBalance(String error) {
		 super(error);
	}

}
