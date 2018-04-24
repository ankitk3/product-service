package com.sapient.service;

import java.util.List;

import com.sapient.db.model.Product;

public interface ProductService {

	Product getProduct(int id);
	Product findProductByType(String type);
	String deleteProduct(int id);
	String saveProduct(Product product);
	List<Product> getAllProducts();
}
