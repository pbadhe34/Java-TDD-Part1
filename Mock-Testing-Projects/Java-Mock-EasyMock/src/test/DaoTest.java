 package test;
  
 import app.*;

 import junit.framework.TestCase;
 import org.easymock.classextension.EasyMock; //EasyMock extension library
 import java.io.IOException;

  

public class DaoTest extends TestCase 
{

    public void testUserDAO()  
    {
        System.out.println("Starting the UserDao Test ...");
        User u1 = new User("Sunil");

        UserDao  mockdao = EasyMock.createMock(UserDao.class);

        EasyMock.expect(mockdao.getSalary(u1.getName())).andReturn(15000);
        EasyMock.replay(mockdao); 


        int salary = u1.FindSalary(mockdao);
        assertEquals(15000, salary);



       //test for another user the same dao mock object by reseting it
        // EasyMock.reset(mockdao); 


  }

public static void main(String args[]) {
        System.out.println("Starting the DaoTest");
        junit.textui.TestRunner.run(DaoTest.class);
    }

}