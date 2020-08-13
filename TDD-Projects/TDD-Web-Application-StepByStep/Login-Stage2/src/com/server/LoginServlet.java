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


	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("LoginServlet init ");
		super.init(config);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String name = req.getParameter("uName");
		String pwd = req.getParameter("uPass");
	 
	 
		PrintWriter out= resp.getWriter();
		
		/*if(name.equals("ashok") && pwd.equals("morYa"))
			out.write("Login successfull...");
		else
			out.write("Login Error...");*/
		
		if(service.validateUser(name, pwd))
			out.write("Login successfull...");
		else
			out.write("Login Error...");

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write("The Login Action doesnot expose get method");

	}

	
}
