package com.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

import com.data.Calculator;


public class Junit5_Assumptions {
	
	private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnCiServer() {
    	System.out.println("Assum that it is running in CI Server");
        assumeTrue("CI".equals(System.getenv("ENV")));
        
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
    	System.out.println("Assum that it is the Dev Env");
        assumeTrue("DEV".equals(System.getenv("ENV")),
            () -> "Aborting test: not on developer workstation");
         
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
            () -> {
                // perform these assertions only on the CI server
                assertEquals(8, calculator.multiply(4, 2));
            });

        // perform these assertions in all environments
        assertEquals(42, calculator.multiply(6, 7));
    }


}
