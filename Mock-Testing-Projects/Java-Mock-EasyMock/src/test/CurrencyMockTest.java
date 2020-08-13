package test;

import app.*;

import junit.framework.TestCase;
import org.easymock.EasyMock; //EasyMock Library class
import org.easymock.EasyMockSupport;
import org.easymock.IExpectationSetters;

import java.io.IOException;

/*
 The exchange rate is passed in from outside the class Currency. It is not constructed inside the class. This is critical to enable mock out the exchange rate so the tests can run without talking to the real exchange-rate server. It also enables client applications to supply different sources of exchange-rate data.
 */
//JUnit Version 3.x compatibke tests
public class CurrencyMockTest extends TestCase {

	public void testDollarToEurosCoversionByMockObject() throws IOException {
		Currency inputCurrency = new Currency(2.50, "USD");
		Currency outputCurrency = new Currency(3.75, "EUR");

		/*
		 * create a mock version of the ExchangeRate interface by passing the
		 * Class object for that interface to the static EasyMock.createMock()
		 * method The 'EasyMock.createMock()' method returns an instance of
		 * ExchangeRate
		 */
		// The interface proxy implementation on the FLY!

		ExchangeRate ExchangeRatemockObject = EasyMock
				.createMock(ExchangeRate.class);

		/*
		 * Tell the mock what to expect from mock object , pass the method as an
		 * argument to the EasyMock.expect() method. In this case only the
		 * method call..
		 */

		 
		IExpectationSetters<Double> expectedMethod = EasyMock
				.expect(ExchangeRatemockObject.getRate("USD", "EUR"));

		IExpectationSetters<Double> expectedValue = expectedMethod
				.andReturn(1.5);

		 
		 
		// EasyMock records this invocation so it knows what to play back later.

		// Make the mockObject ready to play back its recorded data by invoking
		// the EasyMock.replay() method
		// This resets the mock object so that the next time its methods are
		// called it will begin replaying

		EasyMock.replay(ExchangeRatemockObject); // Reset mock and make ready
													// for running the test

		// Invoke the method by passing the mock object

		inputCurrency.ConverttoEuros(ExchangeRatemockObject);
		// If forget to call EasyMock.replay() before using a mock, get an
		// IllegalStateException
		
		//inputCurrency.ConverttoEuros(ExchangeRatemockObject);
		EasyMock.verify(ExchangeRatemockObject);

	}

	public void testDollarToEurosCoversionValueByMockObject()
			throws IOException {
		Currency inputCurrency = new Currency(2.50, "USD");

		// The inetrface proxy implementation on the FLY!

		ExchangeRate ExchangeRatemockObject = EasyMock
				.createMock(ExchangeRate.class);
		
		//EasyMock mock = (EasyMock) EasyMock.createMock(ExchangeRate.class);
		
		IExpectationSetters<Double> expectedMethod = EasyMock.expect(ExchangeRatemockObject.getRate("USD", "EUR")).andReturn(3.0);
		
		 
		EasyMock.replay(ExchangeRatemockObject); // Reset mock and make ready

	
		//EasyMock.reset(ExchangeRatemockObject);
		
		Currency actualCurrency = inputCurrency
				.ConverttoEuros(ExchangeRatemockObject); // Invoke the test by
		
		//Currency outputCurrency = new Currency(3.75, "EUR");
															// using Mock Object
		//assertEquals(new Currency(7.5,"EUR"), actualCurrency);// Verify the results	

		EasyMock.verify(ExchangeRatemockObject);

		/*
		 * Tell the mock what to expect from mock object , pass the method as an
		 * argument to the EasyMock.expect() method. Add expected return value
		 * by calling .andReturn() to specify what should come out as a result of calling this method
		 */

		 
/*		IExpectationSetters<Double> expectedMethod = EasyMock
				.expect(ExchangeRatemockObject.getRate("USD", "EUR"));

		IExpectationSetters<Double> expectedValue = expectedMethod
				.andReturn(1.5);
		 
		EasyMock.replay(ExchangeRatemockObject); // Reset mock and make ready
													// for running the test

		Currency actualCurrency = inputCurrency
				.ConverttoEuros(ExchangeRatemockObject);	
		 
		EasyMock.verify(ExchangeRatemockObject);
		*/
	 

	}

	public void testDollarToEurosCoversionValueMultipleTimesByMockObject()
			throws IOException {
		Currency inputCurrency = new Currency(2.50, "USD");
		Currency outputCurrency = new Currency(5.0, "EUR");

		// Create the inetrface implementation proxy on the FLY!

		ExchangeRate ExchangeRatemockObject = EasyMock
				.createMock(ExchangeRate.class);

		/*
		 * IExpectationSetters<Double > expectedMethod =
		 * EasyMock.expect(ExchangeRatemockObject.getRate("USD", "EUR"));
		 * IExpectationSetters<Double > expectedValue =
		 * expectedMethod.andReturn(1.5);
		 */

		EasyMock.expect(ExchangeRatemockObject.getRate("USD", "EUR"))
				.andReturn(2.0);

		EasyMock.replay(ExchangeRatemockObject); // Reset mock and make ready
													// for running the test

		Currency actualCurrency = inputCurrency
				.ConverttoEuros(ExchangeRatemockObject); // Invoke the test by
															// using Mock Object
		assertEquals(outputCurrency, actualCurrency);// Verify the results

		System.out.println("\nThe first output currency value is  "
				+ outputCurrency);

		System.out.println("\nReusing the same mock object for another test\n");

		// Reuse the mockObject for other tests..by resetting it

		EasyMock.reset(ExchangeRatemockObject);
		EasyMock.expect(ExchangeRatemockObject.getRate("USD", "EUR"))
				.andReturn(3.0);// return new exchange rate
		EasyMock.replay(ExchangeRatemockObject);

		Currency SecondCurrency = new Currency(5.0, "USD");
		Currency newCurrency = new Currency(15.0, "EUR");

		Currency next = SecondCurrency.ConverttoEuros(ExchangeRatemockObject); // Invoke
																				// second
																				// test
																				// by
																				// using
																				// Mock
																				// Object
		assertEquals(newCurrency, next);// Compare the results
		System.out.println("\nThe second output currency value is  "
				+ newCurrency);

	}
	
	public void testDollarToEurosCoversionByInnerClass()
	{
		     ExchangeRate rateCoverter = new ExchangeRate(){			
			 
				public double getRate(String inputCurrency, String outputCurrency)
						throws IOException 
						{
						System.out.println("The inputCurrency is  "+inputCurrency);
						System.out.println("The outputCurrency is  "+outputCurrency);
	
					    return 2.0;
				       }
	
				 
				public void updateDB(String name) {
					System.out
							.println("Currency.main(...).new ExchangeRate() {...}.updateDB()");
					
				}
		  };
		    
		    Currency inputCurrency = new Currency(2.50, "USD");
	        Currency outputCurrency = new Currency(5.0, "EUR");
	        
	        Currency actualCurrency = inputCurrency.ConverttoEuros(rateCoverter); //Invoke the test by using Mock Object
	        System.out.println("The actualCurrency returned is  "+actualCurrency);
	        
	    	assertEquals(outputCurrency,actualCurrency);// Compare the results
	    	
 }
 
	

	 

}