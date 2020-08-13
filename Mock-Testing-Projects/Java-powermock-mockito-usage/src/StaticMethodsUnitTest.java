

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.data.ClassForPartialMocking;
import com.data.ClassWithFinalMethods;
import com.data.ClassWithStaticMethods;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;
 

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.data.*")
public class StaticMethodsUnitTest {

    @Test
    public void testWithMockConstructorUsingPowerMockito() throws Exception {
        ClassWithFinalMethods mock = PowerMockito.mock(ClassWithFinalMethods.class);
        PowerMockito.whenNew(ClassWithFinalMethods.class).withNoArguments().thenReturn(mock);

        ClassWithFinalMethods collaborator = new ClassWithFinalMethods();
        PowerMockito.verifyNew(ClassWithFinalMethods.class).withNoArguments();
       // PowerMockito.verifyNew(ClassWithFinalMethods.class).withArguments(arg0, arg1);
        
    }
    @Test
    public void testFinalInstanceMethodWithMock() throws Exception {
        
       // ClassWithFinalMethods collaborator = new ClassWithFinalMethods(); 
        ClassWithFinalMethods mockCollaborator = PowerMockito.mock(ClassWithFinalMethods.class);

        PowerMockito.when(mockCollaborator.testMethod()).thenReturn("Hello User!");
        String welcome = mockCollaborator.testMethod();
        Mockito.verify(mockCollaborator).testMethod();
        assertEquals("Hello User!", welcome);
    }

    @Test(expected = RuntimeException.class)
    public void testStaticMethodsExceptionWithPowerMock() {
    	PowerMockito.mockStatic(ClassWithStaticMethods.class);

    	PowerMockito.when(ClassWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("Hello Dada!");
    	PowerMockito.when(ClassWithStaticMethods.secondMethod()).thenReturn("Nothing special");
        
    	//PowerMockito.doThrow(new RuntimeException()).when(ClassWithStaticMethods.class);//on any method throw the exception    
        
    	try {
			PowerMockito.when(ClassWithStaticMethods.class, "thirdMethod").thenThrow(new RuntimeException());
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
        ClassWithStaticMethods.thirdMethod();   

        
    }
    @Test
    public void testStaticMethodsWithReturnValues() {
    	PowerMockito.mockStatic(ClassWithStaticMethods.class);

    	PowerMockito.when(ClassWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("Hello Dada!");
    	PowerMockito.when(ClassWithStaticMethods.secondMethod()).thenReturn("Nothing special");
        

        String firstWelcome = ClassWithStaticMethods.firstMethod("Whoever");
        String secondWelcome = ClassWithStaticMethods.firstMethod("Whatever");

        assertEquals("Hello Dada!", firstWelcome);
        assertEquals("Hello Dada!", secondWelcome);

        PowerMockito.verifyStatic(ClassWithStaticMethods.class, times(2));      
         
    }

    @Test
    public void testStaticMethodsWithAnyValues() {
    	PowerMockito.mockStatic(ClassWithStaticMethods.class);
        
        ClassWithStaticMethods.firstMethod(Mockito.anyString());
        ClassWithStaticMethods.firstMethod("abbsnsns");
        ClassWithStaticMethods.firstMethod("ttswdfff");

        PowerMockito.verifyStatic(ClassWithStaticMethods.class, times(2));
         
    }
    @Test
    public void verifyStaticMethodsNeverCalled() {
    	PowerMockito.mockStatic(ClassWithStaticMethods.class);     
         

    	PowerMockito.verifyStatic(ClassWithStaticMethods.class, Mockito.never());
        
       // ClassWithStaticMethods.secondMethod();

        //ClassWithStaticMethods.thirdMethod();
    }
    @Test
    public void verifyPartialMockingReturnWithSpy() throws Exception {
       
    	String returnValue;

    	PowerMockito.spy(ClassForPartialMocking.class);
        
        PowerMockito.when(ClassForPartialMocking.testStaticMethod()).thenReturn("I am a static mock method.");
        returnValue = ClassForPartialMocking.testStaticMethod();
        
        assertEquals("I am a static mock method.", returnValue);   
        PowerMockito.verifyStatic(ClassForPartialMocking.class);

         
    }
    @Test
    public void verifyPartialMockingOnPrivateInstanceMethod() throws Exception {
                

        ClassForPartialMocking collaborator = new ClassForPartialMocking();
        ClassForPartialMocking mock = PowerMockito.spy(collaborator);        

        PowerMockito.when(mock, "privateMethod").thenReturn("I am from private mock method.");
        String returnValue = mock.privateMethodCaller();
        PowerMockito.verifyPrivate(mock).invoke("privateMethod");
        assertEquals("I am from private mock method. Welcome to the Java world.", returnValue);
    }
}