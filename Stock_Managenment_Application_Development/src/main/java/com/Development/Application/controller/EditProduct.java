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

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
	
		 String stN = request.getParameter("id");
		 int i = Integer.parseInt(stN);
		ProductDTO5 da = new ProductDTO5();
		ProductDTO1 product = da.editProduct(i);
		
            writer.print("<h1 align='center/>Update Product</h1>"+
				  "<hr>"+
				"<h3 align='center'>"+
				"<form action='UpdateProductServlet' method='post'>"+
				" <input type='hidden' name='id' value='"+product.getId()+"'><br>"+
				"<input type='text' name='name' value='"+product.getName()+"'><br>"+
				"<input type='text' name='category' value='"+product.getCategory()+"'><br>"+
			    " <input type='text' name='company' value='"+product.getCompany()+"'><br>"+
				 "<input type='number' name='quantity' value='"+product.getQuantity()+"'><br>"+
				 "<input type='number' name='price' value='"+product.getPrice()+"'><br>"+
				 "<input type='submit' value='Update Product'>"+
			        "</form>"+				
				 "</h3>");		
	}
}
