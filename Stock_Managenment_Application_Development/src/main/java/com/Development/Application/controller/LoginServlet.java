package com.Development.Application.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Application.application.dao.ProductDTO5;
import com.Development.product.model.ProductDTO1;






@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
	    
	    String userName = request.getParameter("username");
	    String password1 = request.getParameter("password");
	    
	    
	    
	    if(userName.equals("admin")&&password1.equals("admin")) {
	  
	    	writer.print("Registartion succesfully");
	    	
	    }else {
		writer.print("Login failed");
	 }
   }
}