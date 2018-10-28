package com.prateek.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.prateek.springdata.product.entities.Product;
import java.lang.String;
import java.util.List;

/*    
 * ================================== CREATING REPOSITORY ==================================================================
 * -> We will create a repository for our entity (table) in our database by extending CrudRepository interface of Spring.
 * -> We need to provide CrudRepository<T, ID>, T and ID. T is the entity name for which repo is created. In our case it is
 *    Product. 
 * -> ID is, what is the type of the ID in the entity. In our case type of id is Integer in Product entity. 
 * 
 * =================================== CREATING FINDER METHODS ============================================================
 * -> We have declared our methods according to fields set in Product class. Spring Data at runtime will execute 
 * 	  SQL queries and return result using this finder methods like findByName(String name).  
 * -> Methods should be named appropriately so that Spring Data can recognize it and run SQL queries appropriately.
 * 
 */

public interface ProductRepository extends CrudRepository<Product, Integer> {
		List<Product> findByName(String name);
		
		List<Product> findByNameAndDesc(String name, String desc);
		
		List<Product> findByPriceGreaterThan(double price);
		
		List<Product> findByDescContains(String desc);
		
		List<Product> findByPriceBetween(double price1,double price2);
		
		List<Product> findByDescLike(String desc);
		
		List<Product> findByIdIn(List<Integer> ids);
}
