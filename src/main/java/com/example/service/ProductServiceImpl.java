package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.entity.Product;
@Service 
public class ProductServiceImpl implements ProductService{

    private Map<String, Product> products = new HashMap<>();

    @Override
    public Product addProduct(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        products.put(id, product);
        return product;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Map<String, Object> generateBill() {
        double totalPrice = 0;
        for (Product product : products.values()) {
            totalPrice += product.getPrice() * product.getQuantity();
        }

        double cgst = totalPrice * 0.09;
        double sgst = totalPrice * 0.09;
        double finalTotal = totalPrice + cgst + sgst;

        Map<String, Object> bill = new HashMap<>();
        bill.put("products", products);
        bill.put("totalPrice", totalPrice);
        bill.put("cgst", cgst);
        bill.put("sgst", sgst);
        bill.put("finalTotal", finalTotal);

        return bill;
    }
	
	

}
