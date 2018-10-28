package com.prateek.springdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
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
	 *  Test the findByName() method declared in our repository 
	 */
	@Test
	public void findByName() {
		List<Product> products = repository.findByName("TV");
		products.forEach(p->System.out.println(p.getName()+" "+p.getPrice())); //Using Lambda expression to display name and price of product
		assertEquals(products.get(0).getPrice(), 1000,0.00);
	}
	
	/*
	 *  Test the findByNameAndDesc() method declared in our repository 
	 */
	@Test
	public void findByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("Washer", "From LG");
		products.forEach(p->System.out.println(p.getName()+" "+p.getPrice())); //Using Lambda expression to display name and price of product
		assertEquals(products.get(0).getPrice(), 2000,0.00);
	}
	
	/*
	 *  Test the findByPriceGreaterThan() method declared in our repository 
	 */
	@Test
	public void findByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(1000.00);
		products.forEach(p->System.out.println(p.getName()+" "+p.getPrice()));
		assertEquals("Washer",products.get(0).getName());
		assertEquals("Dryer",products.get(1).getName());
	}
	
	/*
	 *  Test the findByDescContains() method declared in our repository 
	 */
	@Test
	public void findByDescContains() {
		List<Product> products = repository.findByDescContains("LG");
		products.forEach(p->System.out.println(p.getName()+" "+p.getPrice()));
		assertEquals("Washer",products.get(0).getName());
		assertEquals("Dryer",products.get(1).getName());
	}
	
	/*
	 *  Test the findByPriceBetween() method declared in our repository 
	 */
	@Test
	public void findByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(1200.000,1600.000);
		assertEquals("Dryer",products.get(0).getName());
	}
	
	/*
	 *  Test the findByDescLike() method declared in our repository 
	 */
	@Test
	public void findByDescLike() {
		List<Product> products = repository.findByDescLike("%LG%");
		assertEquals("Washer",products.get(0).getName());
		assertEquals("Dryer",products.get(1).getName());
	}
	
	/*
	 *  Test the findByIdIn() method declared in our repository 
	 */
	@Test
	public void findByIdIn() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<Product> products = repository.findByIdIn(list);
		assertEquals("IWatch",products.get(0).getName());
		assertEquals("TV",products.get(1).getName());
		assertEquals("Washer",products.get(2).getName());
	}



}
