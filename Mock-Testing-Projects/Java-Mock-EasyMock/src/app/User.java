
package app;

import java.io.IOException;
import java.sql.*;


public class User {

    
    private String name;


    public User(String uname) {
        this.name = uname;
    }

     
    public int FindSalary(UserDao dao)
    {
        System.out.println("Starting theFindSalaries  with userDao proxy implementation");
        System.out.println("The current UserDao proxy mock object is "+dao);
         
        int s1 = dao.getSalary(name);
        System.out.println("The salary for current User is "+s1);
        return s1;         
    }

    public String getName()
   {
      return name;
   }

    

     

}