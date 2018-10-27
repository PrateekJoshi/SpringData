package com.prateek.springdata.product.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * -> This class will represent a table product in our database using @Entity annotation using JPA.
 * -> @Column is needed in case our field name is different from table field name
 * -> We can use @Table (name="table_name") to map Product class to a table name 'table_name'
 */

@Entity
@Table
public class Product {
	
	@Id
	private int id;
	
	private String name;
	
	@Column(name="description")
	private String desc;
	
	private Double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
