package org.app;

 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.app.data.Account;
import org.app.data.SavingAccount;
import org.data.DataBaseServiceDummy;
import org.data.DataBaseException;
import org.data.DataBaseService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.MockedStatic;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.verification.VerificationMode;

import com.app.BankApp;

public class TestDataBaseMockOnBank {

	@Test
	public void checkBankAppAccountNameWithMock() {
		DataBaseService dbMock = Mockito.mock(DataBaseService.class);
		int accountKey = 101;
		String accountNameToReturn = "Viju Bhosale";

		Mockito.when(dbMock.readAccountName(accountKey)).thenReturn(accountNameToReturn);

		BankApp app = new BankApp();
		app.setService(dbMock);
		
		String accountName = app.getAccountName(accountKey);
		assertEquals(accountNameToReturn, accountName);
		
		String accountName2 = app.getAccountName(accountKey);
		
		//at least and max one call
	   // Mockito.verify(dbMock).readAccountName(accountKey);
		 
		 
		//Verification Matchers for verifying actual calls to stubs
		
		//Verify the invocation on Mock object methods  whether the mocked method was called/interacted 
       // by setting up the Mock behaviour.
		
		VerificationMode mode1 = Mockito.never();	
		VerificationMode mode3 = Mockito.atLeastOnce();
		VerificationMode mode2 = Mockito.atLeast(1);		
		
		VerificationMode mode4 = Mockito.atMostOnce();
		VerificationMode mode5 = Mockito.atMost(2);	
		
		VerificationMode mode6 = Mockito.calls(3);	
		
		VerificationMode mode7 = Mockito.only();
		VerificationMode mode8 = Mockito.times(4);	 
		 
		VerificationMode mode9 = Mockito.after(12500);
		
		VerificationMode mode10 = Mockito.timeout(4500);
		
		//Mockito.verifyNoInteractions(mock1, mock2);
		
		//Mockito.verifyNoInteractions(dbMock);
		
		//Mockito.verifyNoInteractions(dbMock, mock2);
		//Mockito.verifyZeroInteractions(dbMock);
		//Mockito.verifyZeroInteractions(dbMock, mock2);
		 
		Mockito.verify(dbMock, mode5).readAccountName(accountKey);
	}
	
	@Test
	public void checkBankAppAddAccountDoNothing() throws DataBaseException {
		DataBaseService dbMock = Mockito.mock(DataBaseService.class);
		
		Account obj = new Account();
		obj.setName("Baba");
		
		
		//Mockito.when(dbMock.addAccountObject(obj)).thenReturn(obj);		 
		
		Mockito.doNothing().when(dbMock).addAccountObject(obj);		  
		
		BankApp app = new BankApp();
		app.setService(dbMock);	
		app.addAccount(obj); 	 
		
		Mockito.verify(dbMock).addAccountObject(obj);		 
	}
	
	@Test
	public void checkBankAppAddAccountObject() throws DataBaseException {
		DataBaseService dbMock = Mockito.mock(DataBaseService.class);
		
		int newId = 12345;
		Account obj = new Account();
		obj.setName("Baba");
		 
		Answer answerMock = new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock inMock) throws Throwable {
				 System.out.println("answer for add account");
				 Account dataToBeAdded = inMock.getArgument(0);
				 dataToBeAdded.setId(newId);				 
				return null;
			}
			
		};
		
		Mockito.doAnswer(answerMock).when(dbMock).addAccountObject(obj);		
		 
		
		BankApp app = new BankApp();
		app.setService(dbMock);	
		app.addAccount(obj); 	
		
		int addedObjectId = obj.getId();
		assertEquals(newId, addedObjectId);
		
		Mockito.verify(dbMock).addAccountObject(obj);		 
	}
	
	@Test
	public void checkBankAppAddAccountException() throws DataBaseException {
		DataBaseService dbMock = Mockito.mock(DataBaseService.class);
		
		int newId = 12345;
		Account obj = new Account();
		obj.setName("Mohan");
		 
		Mockito.doThrow(DataBaseException.class).when(dbMock).addAccountObject(obj);		
		 
		
		BankApp app = new BankApp();
		app.setService(dbMock);			
		
		
		//assertThrows(Exception.class,Executable);
		
		assertThrows(DataBaseException.class,() -> {
			app.addAccount(obj); 	
		  });
		
		Mockito.verify(dbMock).addAccountObject(obj);		 
	}

	@Test
	public void checkBankAppAddAccountRealCall() throws DataBaseException {
		//DataBaseService dbMock = Mockito.mock(DataBaseService.class);
		
		DataBaseServiceDummy dbMock = Mockito.mock(DataBaseServiceDummy.class);  
		
		
		 
		Account obj = new Account();
		obj.setName("Tesha");
		 
	 	 
		Mockito.doCallRealMethod().when(dbMock).addAccountObject(obj);
		
		BankApp app = new BankApp();
		app.setService(dbMock);			
		app.addAccount(obj);
		
		int newId = 4567;
		int addedObjectId = obj.getId();
		assertEquals(newId, addedObjectId);
		
		Mockito.verify(dbMock).addAccountObject(obj);	
		
        MockingDetails details = Mockito.mockingDetails(dbMock);
      
		
		String invocations = details.printInvocations();
		System.out.println("Mock Invocations "+invocations);
		int numbers = details.getInvocations().size();
		System.out.println("Mock Number of Invocations "+numbers);
		int size = details.getStubbings().size();
		System.out.println("Mock stub invocations are "+size);
		
		System.out.println("Mock is mock  "+details.isMock());
		System.out.println("Mock is spy  "+details.isSpy());		 
		
		
	}
	@Test
	public void checkBankAppAddAccountWithSpy() throws DataBaseException {
		//DataBaseService spyMock = Mockito.mock(DataBaseService.class);
		
	  	DataBaseServiceDummy spyMock = Mockito.spy(DataBaseServiceDummy.class);  
		
		 
		Account obj = new Account();
		obj.setName("SpyMan");
		 
	 	 
		Mockito.doCallRealMethod().when(spyMock).addAccountObject(obj);
		
		BankApp app = new BankApp();
		app.setService(spyMock);			
		app.addAccount(obj);//real call
		
		int newId = 4567;
		int addedObjectId = obj.getId();
		assertEquals(newId, addedObjectId);
		
		Mockito.verify(spyMock).addAccountObject(obj);	
		
        MockingDetails details = Mockito.mockingDetails(spyMock);
      
		
		String invocations = details.printInvocations();
		System.out.println("Mock Invocations "+invocations);
		int numbers = details.getInvocations().size();
		System.out.println("Mock Number of Invocations "+numbers);
		int size = details.getStubbings().size();
		System.out.println("Mock stub invocations are "+size);
		
		System.out.println("Mock is mock  "+details.isMock());
		System.out.println("Mock is spy  "+details.isSpy()); 
		
		 
	}
	@Test
	public void testBankAppAddAccountWithArgumentCaptors() throws DataBaseException {		 
		
	  	DataBaseServiceDummy mockObj = Mockito.mock(DataBaseServiceDummy.class);  
	  	System.out.println("The Mock class is "+mockObj.getClass().getName());
	  	
	  	System.out.println("The Mock Type name is "+mockObj.getClass().getTypeName());
	  	System.out.println("The Mock Super class name is "+mockObj.getClass().getSuperclass().getName());
		
		 
		Account obj = new Account();
		obj.setName("Mocked-data");
		 
	 	 
		Mockito.doCallRealMethod().when(mockObj).addAccountObject(obj);
		
		BankApp app = new BankApp();
		app.setService(mockObj);			
		app.addAccount(obj);//real call
		
		int newId = 4567;
		int addedObjectId = obj.getId();
		assertEquals(newId, addedObjectId);
		
	 	 
		
	//	Mockito.verify(mockObj).addAccountObject(obj);	
		Mockito.verify(mockObj).addAccountObject(obj);	
		
        
		 //Capture the arguments passed to mock methods
		ArgumentCaptor<Account> accountArgumentCapture = ArgumentCaptor.forClass(Account.class);
	     
	     //capture the argument when called on mock
		Mockito.verify(mockObj).addAccountObject(accountArgumentCapture.capture());
		
		Account captured = accountArgumentCapture.getValue();
	     
	     assertEquals("Mocked-data", captured.getName());
	     assertEquals(newId, captured.getId());
	     
   }
	 
	 
	@Test
	public void testStaticMethodWithMock() {
	   
       int returnValue = 1111;
	  try (MockedStatic<DataBaseServiceDummy> theMock = Mockito.mockStatic(DataBaseServiceDummy.class)) {
	    theMock.when(DataBaseServiceDummy::calculateAccountID).thenReturn(returnValue);
	    
	    int id = DataBaseServiceDummy.calculateAccountID();
	   assertEquals(returnValue, id);
	  }

	   
	}
	
	@Test(expected = DataBaseException.class)
	public void checkBankAppAddAccountExceptionWithMockitoMatchers() throws DataBaseException {
		DataBaseService dbMock = Mockito.mock(DataBaseService.class);
		
		 
		Account obj = new Account();
		obj.setName("jjs");
		
		Account obj2 = new Account();
		obj2.setName("Test");
		
		Account obj3 = new Account();
		obj3.setName("Dev");
		 
		//Argument Matchers for any object
		 
		Mockito.doThrow(DataBaseException.class).when(dbMock).addAccountObject(Mockito.any());		
		 
		
		BankApp app = new BankApp();
		app.setService(dbMock);	
		
		app.addAccount(new SavingAccount()); 
		app.addAccount(new SavingAccount()); 	
		app.addAccount(obj2); 	
		app.addAccount(obj3); 	
		 
		 
		//Mockito.verify(dbMock).addAccountObject(obj2);	
		Mockito.verify(dbMock).addAccountObject(Mockito.any());
	}
	@Test(expected = RuntimeException.class)  
    public void testListExceptionForAnyIntValue() {  
          
		//Argument Matchers for any int value
    List<String> mocklist = Mockito.mock(List.class);  
      
    Mockito.when(mocklist.get(Mockito.anyInt())).thenThrow(new RuntimeException("Error.."));  
    mocklist.add("string1");
    mocklist.add("string2");
    mocklist.add("string3");
    mocklist.get(2);  
    
    }  
	
	@Test 
    public void testListSizeEveryTimeForAnyValuesAdded() {  
          
		//Argument Matchers for any int value
    List<String> mocklist = Mockito.mock(List.class);  
      
    //arrange
    Mockito.when(mocklist.size()).thenReturn(5);
     
    // act
    int size = mocklist.size();
     
    // assert
    assertEquals(5, size);
    Mockito.verify(mocklist).size();
    Mockito.verify(mocklist, Mockito.times(1)).size();
    
   // Mockito.verify(mocklist, Mockito.never()).size();
    
    }  
	
	@Test 
    public void verifyOrderOfInvocationsWithMock() {  
          
		//Argument Matchers for any int value
    List<String> mocklist = Mockito.mock(List.class);  
      
    // Arrange
    Mockito.when(mocklist.get(Mockito.anyInt())).thenReturn("Hello");
    Mockito.when(mocklist.size()).thenReturn(100);
     
    InOrder mockInvocationOrder = Mockito.inOrder(mocklist);
    
     // Action
    String value = mocklist.get(3);
    int size = mocklist.size();
    String secondValue = mocklist.get(5);    
     
     
    // Assertion of order of invocations
    mockInvocationOrder.verify(mocklist, Mockito.times(1)).get(Mockito.anyInt());
    mockInvocationOrder.verify(mocklist).size();
    mockInvocationOrder.verify(mocklist,Mockito.times(1)).get(Mockito.anyInt());       
    
    }  
	@Test 
    public void verifyMockIntercationAtLeast() {  
          
		//Argument Matchers for any int value
    List<Integer> mocklist = Mockito.mock(List.class);  
      
 // Arrange
    Mockito.when(mocklist.get(Mockito.anyInt())).thenReturn(3);
     
    // Act
    int response = mocklist.get(5);
    response = mocklist.get(2);
     
    // Assert that atLeast 3 times the intenaction has occured
    Mockito.verify(mocklist, Mockito.atLeast(2)).get(Mockito.anyInt());    
    
    }  
	
	@Test 
    public void verifyMockIntercationAtMost() {  
          
		//Argument Matchers for any int value
    List<Integer> mockedIntList = Mockito.mock(List.class);  
      
 // Arrange
    Mockito.when(mockedIntList.get(Mockito.anyInt())).thenReturn(3);
     
    // Act
    int response = mockedIntList.get(5);
    int response2 = mockedIntList.get(2);
   // int response3 = mockedIntList.get(4);
     
    // Assert
    Mockito.verify(mockedIntList, Mockito.atMost(2)).get(Mockito.anyInt());
    Mockito.verify(mockedIntList, Mockito.atMost(2)).size();
    
    }  
	
	 class TestData {
		 
		public String concatenateString(String arg1, String arg2)
		{
		   return arg1.concat(arg2);
		}
	}	 
	
	 
	 
	 @Test
	 public void verifyArgemnetsMatcher() {
		 // Arrange
		 TestData dataObj =  Mockito.mock(TestData.class);
		 
		 //arrange the call setup
		 Mockito.when(dataObj.concatenateString(Mockito.anyString(), Mockito.anyString())).thenReturn("Welcome world!");
		  
		 // Act on mock
		 String response = dataObj.concatenateString("test", "dev");
		 
		 System.out.println("The resoponse is "+response); 
		
		  Mockito.verify(dataObj).concatenateString(Mockito.anyString(),Mockito.anyString());
		  
		  Mockito.verify(dataObj, Mockito.times(1)).concatenateString("test", "dev");
		  
		  Mockito.verify(dataObj, Mockito.atLeastOnce()).concatenateString(Mockito.anyString(),Mockito.anyString());

		  	  
		   
		  		  
		 
	 }
}
