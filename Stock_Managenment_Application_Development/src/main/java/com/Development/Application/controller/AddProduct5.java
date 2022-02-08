package com.Development.Application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Application.application.dao.ProductDTO5;
import com.Development.product.model.ProductDTO1;

/**
 * Servlet implementation class AddProduct5
 */
@WebServlet("/AddProduct5")
public class AddProduct5 extends HttpServlet {
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
//     	String st = request.getParameter("id");
//		int id1 = Integer.parseInt(st);
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String company = request.getParameter("company");
		String quant = request.getParameter("quantity");
		 int quantity = Integer.parseInt(quant);
		String stPrice = request.getParameter("price");
		Double price = Double.parseDouble(stPrice);
		
		ProductDTO1 dtm = new ProductDTO1(0,name,category,company,quantity,price);
	
		ProductDTO5 dta = new ProductDTO5();
	      dta.add(dtm);
	     
	      
		}	
	}

