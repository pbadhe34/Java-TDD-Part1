package test.com.server;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestHttpLoginPage.class, TestLoginServlet.class,TestUserService.class })
 
public class AppTestSuite {

}
