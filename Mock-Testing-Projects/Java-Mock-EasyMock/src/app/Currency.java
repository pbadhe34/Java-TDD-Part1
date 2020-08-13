
package app;

import java.io.IOException;

import test.CurrencyStubTest;

public class Currency {

    private String units;
    private long amount;
    private int cents;


    public Currency(double amount, String code) {
        this.units = code;
        setAmount(amount);
    }

    private void setAmount(double amount) {
        this.amount = new Double(amount).longValue();
        this.cents = (int) ((amount * 100.0) % 100);
    }

    public Currency ConverttoEuros(ExchangeRate converter)
    {
        System.out.println("Starting the ConverttoEuros with ExchangeRate proxy implementation");
        System.out.println("The proxy mock object is "+converter);


        if ("EUR".equals(units)) return this;

        else 
         {
            double input = amount + cents/100.0;
            double rate = 2.0;
            System.out.println("Converter currency orginal rate is "+rate);
            try {
            	
                rate = converter.getRate(units, "EUR");    
            	
                System.out.println("Converter currency new rate is "+rate);
                double output = input * rate;
                System.out.println("Converter Euros output is  "+output);               
                return new Currency(output, "EUR");
            } catch (Exception ex) 
             {
                return null;
            }
        }
    }
    public static void main(String args[]) {
        System.out.println("Starting the CurrencyTest here..");
        
        ExchangeRate rateCoverter = new ExchangeRate(){
			
			 
			public double getRate(String inputCurrency, String outputCurrency)
					throws IOException 
					{
					System.out.println("The inputCurrency is  "+inputCurrency);
					System.out.println("The outputCurrency is  "+outputCurrency);

				    return 2.0;
			       }

			@Override
			public void updateDB(String name) {
				System.out
						.println("Currency.main(...).new ExchangeRate() {...}.updateDB()");
				
			}
		 };
		 
		    Currency inputCurrency = new Currency(2.50, "USD");
	        Currency outputCurrency = new Currency(3.75, "EUR");
	        
	        Currency actualCurrency = inputCurrency.ConverttoEuros(rateCoverter); //Invoke the test by using Mock Object
	        System.out.println("The actualCurrency returned is  "+actualCurrency);
    }


    public boolean equals(Object o) {
        if (o instanceof Currency) {
            Currency other = (Currency) o;
            return this.units.equals(other.units)
                    && this.amount == other.amount
                    && this.cents == other.cents;
        }
        return false;
    }

    public String toString() {
        return amount + "." + Math.abs(cents) + " " + units;
    }

}