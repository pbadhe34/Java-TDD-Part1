package com.server.bank;

public class Dollar extends Currency {
	
 private int currencyValue;
 public int getCurrencyValue() {
	return currencyValue;
}

private static double rupeesConvresionRate = 48.6 ;
 
 public  double getRupeesConvresionRate() {
	return rupeesConvresionRate;
}

public Dollar(int currentValue)
 {
	 this.currencyValue = currentValue;
 }
}
