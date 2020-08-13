package com.test;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestDisplayNameGeneration {
	
	//https://junit.org/junit5/docs/current/user-guide/
	
	@Test
	@DisplayName("Verification Test")
    void verifySomData() {
    	System.out.println("The  test runnig is verifySomData");
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) //Built-in class
    public class Verify_That_A_year_is_not_supported_as_LeapYear {

        @Test
        void if_it_is_zero() {
        	System.out.println("The  test runnig with year value as ZERO");
        }

        @DisplayName("Verify that a negative value is not supported for the leap year computation.")
        @ParameterizedTest(name = "For This Negative UseCase, year {0} is not supported.")
        @ValueSource(ints = { -1, 4 })
        void if_it_is_negative(int year) {
        	System.out.println("The parameterized test runnig with year value as "+year);
        }

    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)  //custom class extension
    class Verify_That_A_year_is_a_Leap_year {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        	System.out.println("Testing for divisible by 4 But not by 100");  
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = { 2016, 2020, 2048 })
        void if_it_is_one_of_the_following_years(int year) {
        	System.out.println("Testing for divisible by 4 But not by 100"); 
        }

    }

    static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testClass.getSimpleName() + ' ' + testMethod.getName();
            return "TestMethod-"+name.replace('_', ' ') + '.';
        }

    }

}