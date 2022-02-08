package com.Development.Application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Application.application.dao.ProductDTO5;
import com.Development.product.model.ProductDTO1;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		ProductDTO5 dao = new ProductDTO5();
		List<ProductDTO1> dt = dao.getProducts();
		
		writer.print("<form action ='SearchProduct' method='post'>"+
		"<input type='text' placeholder='Search..' name='search/'>"+
				"<input type='submit' value='search'>"+
		"</form>");
	
		
		writer.print(
				 "<h3 align='center'><table border='1'>"+
				      "<tr>"+
				           "<th>Product Name</th>"+
				           "<th>Product Category</th>"+
				          "<th>Product Company</th>"+
				          "<th>Product Quantity</th>"+
				            "<th>Product Price</th>"+
				            "<th>Edit/update</th>"+
				            "<th>Delete</th>"+
				            "<th>Add to Cart</th>"+
			      "</tr>");
		
		for(ProductDTO1 dtm :dt) {
			writer.print("<tr>"+
            "<td>"+dtm.getName()+"</td>"+
            "<td>"+dtm.getCategory()+"</td>"+
            "<td>"+dtm.getCompany()+"</td>"+
            "<td>"+dtm.getQuantity()+"</td>"+
            "<td>"+dtm.getPrice()+"</td>"+
//            "<td>"+dtm.getPrice()+"</td>"+
//            "<td>"+dtm.getPrice()+"</td>"+
            "<td><a href='EditProduct?id="+dtm.getId()+"'>Edit</a></td>"+
            "<td><a href='DeleteProduct?id="+dtm.getId()+"'>Delete</a></td>"+
            "<td><a href='AddCart?id="+dtm.getId()+"'>Add to cart</a></td>"+
        "</tr>");
		}
		writer.print("</table></h3>");
		writer.print("</body>");
		
		}
	}

