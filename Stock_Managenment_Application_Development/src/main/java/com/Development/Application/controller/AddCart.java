package com.Development.Application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Application.application.dao.ProductDTO5;
import com.Development.product.model.ProductDTO1;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	List<ProductDTO1> list = new ArrayList<ProductDTO1>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String stId = request.getParameter("id");
		int id = Integer.parseInt(stId);
		
		ProductDTO5 dt = new ProductDTO5();
		ProductDTO1 de = dt.editProduct(id);
		list.add(de);
		
		HttpSession session = request.getSession();
	session.setAttribute("listofProduct",list);
	}
	
	}
