package com.example.service;

import java.util.List;
import java.util.Map;

import com.example.entity.Product;

public interface ProductService {
	
	Product addProduct(Product product);
    List<Product> getProducts();
    Map<String, Object> generateBill();

}
