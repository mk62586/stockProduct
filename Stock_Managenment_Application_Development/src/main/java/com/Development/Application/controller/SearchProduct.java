package com.Development.Application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Application.application.dao.ProductDTO5;
import com.Development.product.model.ProductDTO1;




@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String str = request.getParameter("search");
		//ProductDTO1 de = new ProductDTO1();
		
		ProductDTO5 da = new ProductDTO5();
		//da.searchProducts(str);
		//List<ProductDTO1> dt = da.searchProducts(str);
		Collection<ProductDTO1> dt= da.searchProducts(str);
	if(dt != null)	{
		writer.print("<body>");
		writer.print("<table border='1'>"+
	   "<tr>"+
		"<th>Product name</th>"+
		"<th>Product price</th>"+
		"<th>Product brand</th>"+
		"</tr>");
		
		Stream<ProductDTO1> ps = dt.stream();
		ps.forEach((mn)->{
			writer.print("<tr>)"+
		         "<td>"+mn.getName()+"</td>"+
		         "<td>"+mn.getPrice()+"</td>"+
		         "<td>"+mn.getCategory()+"</td>"+
					"</tr>");
		
		});
	}else {
		writer.print("<p> no product found</p>");
	}
	writer.print("</table>");
	writer.print("</body>");
	}
	}





