 package test;
  
 import app.*;

 import junit.framework.TestCase;
 import org.easymock.EasyMock; //EasyMock Library class
 import java.io.IOException;

/*
The exchange rate is passed in from outside the class Currency. It is not constructed inside the class. This is critical to enable mock out the exchange rate so the tests can run without talking to the real exchange-rate server. It also enables client applications to supply different sources of exchange-rate data.
*/ 

public class TestException extends TestCase 
{


  // The Currency class is supposed to return null when getRate() throws an IOException. 
    public void testByMockObject() throws IOException 
    {
        Currency testObject = new Currency(2.50, "USD");
        Currency expected = new Currency(3.75, "EUR");

        ExchangeRate mockObject = EasyMock.createMock(ExchangeRate.class);  

  /*
   Tell the mock to expect an exception
   */ 
       
        EasyMock.expect(mockObject.getRate("USD", "EUR")).andThrow(new IOException());
        EasyMock.replay(mockObject);
        Currency actual = testObject.ConverttoEuros(mockObject);
        assertNull(actual);
         
    }


 

}