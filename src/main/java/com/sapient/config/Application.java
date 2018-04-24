package com.sapient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sapient.db.model.Product;
import com.sapient.service.ProductService;

@SpringBootApplication(scanBasePackages="com.sapient")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EnableJpaRepositories("com.sapient")
@ComponentScan("com.sapient")
@EntityScan("com.sapient")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(@Autowired ProductService service) {
		return (args) -> {
			// save a couple of Product
			Product prod = new Product();
			prod.setName("Car");
			prod.setType("Toys");
			service.saveProduct(prod);
			prod = new Product();
			prod.setName("Reebok");
			prod.setType("Shoes");
			service.saveProduct(prod);
			prod = new Product();
			prod.setName("Pencil");
			prod.setType("Stationary");
			service.saveProduct(prod);
		};
	}
}
