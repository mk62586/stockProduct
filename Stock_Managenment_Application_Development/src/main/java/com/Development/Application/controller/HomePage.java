package com.Development.Application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Development.product.model.ProductDTO1;


@WebServlet("/HomePage")
public class HomePage extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		writer.print("<h1>Welcome  to Stock Managment Application </h1>"+
		           "<h4><a href='addProduct.html'>AddProduct</a></h4>"+
		           "<h4><a href='ViewProduct'>ViewProduct</a></h4>"+
				   "<h4><a href='EditProduct'>EditProduct</a></h4>");
		
//		String st = request.getParameter("id");
//		int idNo = Integer.parseInt(st);
//		String name = request.getParameter("name");
//		String category = request.getParameter("category");
//		String company = request.getParameter("company");
//		String quantity = request.getParameter("quantity");
//		int quant = Integer.parseInt(quantity);
//		String stPrice = request.getParameter("price");
//		double price = Double.parseDouble(stPrice);
//		
//		ProductDTO1 dto = new ProductDTO1(idNo,name,category,company,quant,price);
//		
//		ProductDAO1 dao = new ProductDAO1(dto);
//		dao.add(dto);
		
	}
}
