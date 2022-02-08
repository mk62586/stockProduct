package com.Development.Application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Application.application.dao.ProductDTO5;
import com.Development.product.model.ProductDTO1;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
    	String st = request.getParameter("id");
		int id = Integer.parseInt(st);
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String company = request.getParameter("company");
		String quant = request.getParameter("quantity");
		 int quantity = Integer.parseInt(quant);
		String stPrice = request.getParameter("price");
		Double price = Double.parseDouble(stPrice);
		
		ProductDTO1 dtm = new ProductDTO1(id,name,category,company,quantity,price);
	
		ProductDTO5 dta = new ProductDTO5();
	      int rowEffect = dta.update(dtm);
	     
	      if(rowEffect>0) {
	    	  writer.print(rowEffect+" update");
//	    	 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ViewProduct");
//	    	 requestDispatcher.include(request, response);
	    	  writer.print("</br><a href='ViewProduct'>view Product</a>");
	      }
	}

}
