package com.prateek.springdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prateek.springdata.product.entities.Product;
import com.prateek.springdata.product.repos.ProductRepository;

@RunWith(SpringRunner.class) // Instead of JUnit Runner, it will run using SpringRunner
@SpringBootTest(classes = com.prateek.springdata.product.ProductDataApplication.class)
public class ProductDataApplicationTests {

	@Autowired
	ProductRepository repository;

	/*
	 * -> Check if all auto-wiring and spring app set's up properly. -> It also
	 * checks if our app is able to connect to database using JDBC properties
	 * defined in application.properties.
	 */
	@Test
	public void contextLoads() {
	}

	/*
	 * In this test we will, 1) Create Product entity. 2) Set its fields 3) Save it
	 * to repository (database)
	 */
	@Test
	public void saveInRepository() {
		Product product = new Product();
		product.setId(1);
		product.setName("Playstation 4");
		product.setDesc("Awesome gaming machine");
		product.setPrice(1000d);

		repository.save(product);
	}

	
	/*
	 * Test if we can read value from repository
	 */
	@Test
	public void readFromRepository() {
		Optional<Product> product = repository.findById(1);
		if( product.isPresent() )
		{
			System.out.println("Product found");
			System.out.println("Name: "+product.get().getName()+ " Price: "+product.get().getPrice());
			assertNotNull(product.get());
			assertEquals("Playstation 4", product.get().getName());
		}
		else
		{
			System.out.println("Product not found with id = "+ product.get().getId());
		}
		
	}
	
	
	/*
	 * Update Entity in repositiry
	 */
	@Test
	public void updateRespository() {
		Product product = repository.findById(1).get();
		product.setPrice(2000.199);
		repository.save(product);
		
		product = repository.findById(1).get();
		assertEquals(2000.199, product.getPrice(),0.00);
	}
	
	
	/*
	 * Delete Entity in repositiry
	 */
	@Test
	public void deleteEntityFromRepository() {
		if( repository.existsById(1))
		{
			repository.deleteById(1);
			Optional<Product> product = repository.findById(1);
			assertFalse(product.isPresent());
		}
	}

}
