package com.sapient.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.db.model.Product;
import com.sapient.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOGGER = Logger.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts() {
		try {
			return productService.getAllProducts();
		} catch(Exception e) {
			LOGGER.info("Error while fetching all products.",e);
			return null;
		}
    }
	@GetMapping(value="/{id}")
	public Product getProduct(@PathVariable int id) {
		try {
			return productService.getProduct(id);
		} catch(Exception e) {
			LOGGER.info("Error while fetching product for "+id,e);
			return null;
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveProduct(@RequestBody Product product) {
		try {
			return productService.saveProduct(product);
		} catch(Exception e) {
			LOGGER.info("Error while saving product "+product,e);
			return "FAILURE";
		}
    }
	
	@DeleteMapping(value="/{id}")
    public String deleteProduct(@PathVariable int id) {
		try {
			return productService.deleteProduct(id);
		} catch(Exception e) {
			LOGGER.info("Error while removing product "+id,e);
			return "FAILURE";
		}
    }
	@GetMapping(value="/type/{type}")
    public Product getProductByType(@PathVariable String type) {
		try {
			return productService.findProductByType(type);
		} catch(Exception e) {
			LOGGER.info("Error while fetching product by type "+type,e);
			return null;
		}
    }
}
