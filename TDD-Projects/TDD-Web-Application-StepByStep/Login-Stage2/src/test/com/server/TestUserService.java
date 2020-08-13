package test.com.server;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.data.service.UserService;
import com.data.service.UserServiceImpl;
import com.server.LoginServlet;
 
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


 
public class TestUserService {  
	  
	 
 
	@Test
	public void verifyServiceObject() {		
		
		UserService obj = new UserServiceImpl();
		assertNotNull(obj);
	} 
	
	@Test
	public void verifyValidationSuccess() {		
		
		UserService obj = new UserServiceImpl();
		boolean res = obj.validateUser("ashok","morYa");
		assertTrue(res);
	} 
	
	@Test
	public void verifyValidationError() {		
		
		UserService obj = new UserServiceImpl();
		boolean res = obj.validateUser("baba","sedd");
		assertFalse(res);
	} 
}

	
	  
