package com.test;

import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer.Random;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To control the order in which test methods are executed, annotate  test class or test interface with 
 * @TestMethodOrder and specify the desired MethodOrderer implementation. 
 * Alphanumeric: sorts test methods alphanumerically based on their names and formal parameter lists.
   OrderAnnotation: sorts test methods numerically based on values specified via the @Order annotation.
   Random: orders test methods pseudo-randomly and supports configuration of a custom seed.*/

//@TestMethodOrder(Random.class)
//@TestMethodOrder(Alphanumeric.class)
@TestMethodOrder(OrderAnnotation.class)
class TestCaseOrder {
	
	
	
	  @Test
	  @Order(2)
	    void verifyWithEemptyValues() {
	        // perform assertions against empty values
	    	System.out.println("verify with empty values at second highest order");
	    }
	  @Test
	    @Order(3)
	    void checkWithValidValues() {
	        // perform assertions against valid values
	    	System.out.println("verify with valid values at next order");
	    }

    @Test
    @Order(1)
    void testWithNullValues() {
        // perform assertions against null values
    	System.out.println("verify with null values at highest order");
    }

   
 
    
  

}