package com.Development.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor 
@Data
public class ProductDTO1 {
private int id;
private String name;
private String category;
private String company;
private int quantity;
private double price;

}
