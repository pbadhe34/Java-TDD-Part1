package com.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
@Tag("model")
public class TestWithTags {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
    	System.out.println("Testing for tax only");
    }
    
    @Test    
    void testingModel() {
    	System.out.println("Testing for model data");
    }
    
    @Test    
    void testingFast() {
    	System.out.println("Testing for fast tag vehicle at Toll Plaza");
    }

}