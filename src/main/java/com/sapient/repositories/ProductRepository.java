package com.sapient.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.db.model.Product;

/**
 * DB Repository for Product table.
 * @author ankit
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	Product findOneByType(String type);
}
