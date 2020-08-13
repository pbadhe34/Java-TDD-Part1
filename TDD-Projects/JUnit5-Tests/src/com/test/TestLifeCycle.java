package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

//import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;


/*
Test Class: any top-level class, static member class, or @Nested class that contains at least one test method.

Test classes must not be abstract and must have a single constructor.

Test Method: any instance method that is directly annotated or meta-annotated with @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, or @TestTemplate.

Lifecycle Method: any method that is directly annotated or meta-annotated with @BeforeAll, @AfterAll, @BeforeEach, or @AfterEach.
Test classes, test methods, and lifecycle methods are not required to be public, but they must not be private.

*/

class TestLifeCycle {

    @BeforeAll
    static void initAll() {
    	System.out.println("This is a before all the tests");
    	}

    @BeforeEach
    void init() {
    	System.out.println("\n**This is a before each of the test");
    }

    @Test
    void succeedingTest() {
    	System.out.println("This is a suucessful test");
    }

    @Test
    void failingTest() {
       // fail("This is a failing test");
    }

    @Test
    @Disabled("This is disabled test")
    @DisplayName("MyTest")
    void skippedTest() {
    	System.out.println("You donot see this test");
    }
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void runOnlyOn64BitArchitectures() {
    	System.out.println("This will  run  only with 64 bit systems");
    }


    @EnabledOnOs(OS.MAC)
    void testOnlyOnMacOs() {
    	System.out.println("This is being executed only on MAC MC");
    }
    
    @Test
    @EnabledOnOs({ OS.LINUX, OS.MAC })
    void runOnLinuxOrMac() {
    	System.out.println("This is being executed either on MAC or Linux");
    }
    
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void verifyRunOnWindows() {
    	System.out.println("This will run ONLY on windows");
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void notRunOnWindows() {
    	System.out.println("This will not run on windows");
    }
    
    @EnabledOnJre(JRE.JAVA_8)
    @Test    
    void runWithJava8Only() {
    	System.out.println("This will  run only with Java8");
    }
    
   
    @Test
    @EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_10 })
    void verifyOnJava9Or10() {
    	System.out.println("This will  run  with Java9 or 10");
    }
    
    
	/*
	 * @Test
	 * 
	 * @DisabledOnJre(JRE.OTHER) void verifyNotRunOnJavaLessThan8() {
	 * System.out.println("This will NOT run with Java version less than 8"); }
	 */

	/*Custom annotations
	 * @Target(ElementType.METHOD)
	 * 
	 * @Retention(RetentionPolicy.RUNTIME)
	 * 
	 * @Test
	 * 
	 * @EnabledOnOs(MAC)
	 * 
	 * @interface TestOnMac {
	 * 
	 * }
	 * 
	 * @TestOnMac
    void testOnMac() {
    	System.out.println("This is being executed alos on MAC MC");
    }

	 */
    
    @Test
    @Timeout(value = 3000, unit = TimeUnit.MILLISECONDS)
    @DisplayName("TimeOut Test")
    void waitForLongTime()
    {
    	 System.out.println("This test is waiting for certain result till certain time..");
    	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			 
			System.out.println("Who dared to interruot me?") ;
		}
    	 System.out.println("Where am I ?..");
    	 
    }
    @Test
    @DisplayName("╯°□°）╯")
    void abortedTest() {
        assumeTrue("abc".contains("b"));
        System.out.println("Verified the assumption..");
      //  fail("This test should have been aborted");
    }

    @AfterEach
    void tearDown() {
    	System.out.println("This is a after each test to tear down");
    }

    @AfterAll
    static void tearDownAll() {
    	System.out.println("\nThis is a after all the tests");
    }
    
    @RepeatedTest(3)
    void verifyWithRepeatedTest() {
    	System.out.println("Verified withy repeated exec!ution of this test..");         
    }
    
    @Test
    @DisplayName("Verify That Exception Occurs")
    void checkForException() {        
         
			
	    ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
			  {final int num = 100/0;});		 
          	
	 
	  
			/*
			 *  int data[] = new int[1];
			 * ArithmeticException exception = assertThrows(ArithmeticException.class, () ->
			 * {final int num = data[1];});
			 */
			     		   
		 
    	//assertEquals("/ by zero", exception.getMessage());
        System.out.println("Verified that the exception occurs!..");         
    }
   
 

}