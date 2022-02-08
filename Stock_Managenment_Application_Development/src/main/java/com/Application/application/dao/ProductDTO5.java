package com.Application.application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Development.product.model.ProductDTO1;


public class ProductDTO5 {	
	
	private Connection getConnection() {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cj1?user=root&password=roothaider62586@");
			return con;
		} catch (ClassNotFoundException  | SQLException e) {
			return null;
		}
	}
	public void add(ProductDTO1 dto) {
		try {
			Connection con = getConnection();
PreparedStatement prepareStatement = con.prepareStatement("insert into stock_info(name,category,company,quantity,price)values(?,?,?,?,?)");
			prepareStatement.setString(1, dto.getName());
			prepareStatement.setString(2, dto.getCategory());
			prepareStatement.setString(3, dto.getCompany());
			prepareStatement.setInt(4,dto.getQuantity());
			prepareStatement.setDouble(5, dto.getPrice());
			prepareStatement.executeUpdate();
			System.out.println("Data added");
            } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<ProductDTO1> getProducts() {
		Connection connection = getConnection();	
	try {
		Statement statement = connection.createStatement();
	     ResultSet resultSet = statement.executeQuery("select * from stock_info");
	     List<ProductDTO1> list = new ArrayList<>();
	     
	     while(resultSet.next()) {
 	    	 ProductDTO1 dto = new ProductDTO1();
//	    	 dto.setId(resultSet.getInt("id"));
//	    	     dto.setName(resultSet.getString("Name"));
//	    	 dto.setPrice(resultSet.getInt("Price")); 
//	    	 dto.setBrand(resultSet.getString("Brand"));
//	    	 list.add(dto);
	    	 
	    	    dto.setId(resultSet.getInt("id"));
	         	dto.setName(resultSet.getString("name"));
				dto.setCategory(resultSet.getString("category"));
				dto.setCompany(resultSet.getString("company"));
				dto.setQuantity(resultSet.getInt("quantity"));
				dto.setPrice(resultSet.getDouble("price"));
				list.add(dto);
				System.out.println("Data added");   	 
	  }
	     return list;
	  
	} catch (SQLException e) {
		
		e.printStackTrace();
		return null;
	    }
     }

	public ProductDTO1 editProduct(int id) {
		
		Connection connection = getConnection();
		try {
		PreparedStatement prepareStatement = connection.prepareStatement("select * from stock_info where id=?");
		prepareStatement.setInt(1,id);
		
		ResultSet resultSet = prepareStatement.executeQuery();
		
		resultSet.next();
		
		ProductDTO1 dt = new ProductDTO1();
		dt.setId(resultSet.getInt("id"));
		
		//dt.setId(resultSet.getInt("id"));
		dt.setName(resultSet.getString("name"));
		dt.setCategory(resultSet.getString("category"));
		dt.setCompany(resultSet.getString("company"));
		dt.setQuantity(resultSet.getInt("quantity"));
		dt.setPrice(resultSet.getDouble("price"));
		return dt;
        } catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}
	public int update(ProductDTO1 dtm) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("update stock_info set name=?,category=?,company=?,quantity=?,price=? where id=?");
			prepareStatement.setString(1, dtm.getName());
			prepareStatement.setString(2, dtm.getCategory());
			prepareStatement.setString(3, dtm.getCompany());
			prepareStatement.setInt(4, dtm.getQuantity());
			prepareStatement.setDouble(5, dtm.getPrice());
			prepareStatement.setInt(6, dtm.getId());
			int executeUpdate = prepareStatement.executeUpdate();
			return executeUpdate;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}	
	}
	public ProductDTO1 deleteProduct(int id) {
		
			Connection connection = getConnection();
		
			try {
				PreparedStatement prepareStatement = connection.prepareStatement("delete from stock_info where id=?");
				prepareStatement.setInt(1,id);
				
				   int executeUpdate = prepareStatement.executeUpdate();
				
				   ProductDTO1 dt = new ProductDTO1();
					dt.setId(id);
					return dt;
				
		        } catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	public List<ProductDTO1> searchProducts(String search){
		Connection connection = getConnection();	
	try {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM stock_info WHERE name LIKE ?");
		ps.setString(1, "%" + search + "%");
		ResultSet set = ps.executeQuery();
		
	     List<ProductDTO1> list = new ArrayList<>();
	     
	     while(set.next()) {
 	    	 ProductDTO1 dto = new ProductDTO1();
//	    	 dto.setId(resultSet.getInt("id"));
//	    	     dto.setName(resultSet.getString("Name"));
//	    	 dto.setPrice(resultSet.getInt("Price")); 
//	    	 dto.setBrand(resultSet.getString("Brand"));
//	    	 list.add(dto);
	    	 
 	    	 System.out.println(set.getInt("id"));
	    	    dto.setId(set.getInt("id"));
	         	dto.setName(set.getString("name"));
				dto.setCategory(set.getString("category"));
				dto.setCompany(set.getString("company"));
				dto.setQuantity(set.getInt("quantity"));
				dto.setPrice(set.getDouble("price"));
				list.add(dto);
				System.out.println("Data added");   	 
	  }
	     return list;
	  
	} catch (SQLException e) {
		
		e.printStackTrace();
		return null;
	    }
     }
	}




