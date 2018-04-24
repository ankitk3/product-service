package com.sapient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.db.model.Product;
import com.sapient.repositories.ProductRepository;
import com.sapient.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	@Override
	public Product getProduct(int id) {
		return repository.findOne(id);
	}

	@Override
	public Product findProductByType(String type) {
		return repository.findOneByType(type);
	}

	@Override
	public String deleteProduct(int id) {
		repository.delete(id);
		return "SUCCESS";
	}

	@Override
	public String saveProduct(Product product) {
		repository.save(product);
		return "SUCCESS";
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) repository.findAll();
	}

}
