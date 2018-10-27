package com.prateek.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.prateek.springdata.product.entities.Product;

/*
 * -> We will create a repository for our entity (table) in our database by extending CrudRepository interface of Spring.
 * -> We need to provide CrudRepository<T, ID>, T and ID. T is the entity name for which repo is created. In our case it is
 *    Product. 
 * -> ID is, what is the type of the ID in the entity. In our case type of id is Integer in Product entity.   
 */

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
