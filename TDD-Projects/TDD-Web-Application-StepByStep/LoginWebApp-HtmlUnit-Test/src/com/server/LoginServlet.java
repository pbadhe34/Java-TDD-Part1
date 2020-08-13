package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.service.UserService;
import javax.inject.Inject;

public class LoginServlet extends HttpServlet {
	
	@Inject
	public UserService service;
	
	private int num =123; //Not used any more here
	
	private boolean flag = false;


	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init ");
		super.init(config);
	}

	//Add for code coverage test
	private void logMessage(String message)
	{
		 System.out.println("Logging the message here "+message);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String name = req.getParameter("uName");
		String pwd = req.getParameter("uPass");
		
		final String app = null;
		
	    String data; //added for code quality checkup
		
		/*
		 * Comments added for code quality testing
		 */ 
	
		 
		PrintWriter out= resp.getWriter();
		
		/*if(name.equals("ashok") && pwd.equals("morYa"))
			out.write("Login successfull...");
		else
			out.write("Login Error...");*/
		
		//Just for testing code complexity and coverage
		
		 if(flag)
			 out.write("Login not allowed here...");
		/* else
			 out.write("Login  allowed here...");
				  */
		if(service.validateUser(name, pwd))
			out.write("Login successfull...");
		else
			out.write("Login Error...");

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= resp.getWriter();
		 
		out.write("The Login Action doesnot expose get method");

	}
	/*
	 * Comments added for code quality testing part2
	 */

	
}
