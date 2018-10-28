package com.prateek.springdata.idgenerators.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;


/*
 *  For id field we have assigned strategy to,
 *  -> Automatically generate id, (ie AUTO_INCREMENT in SQL)
 *  -> strategy=GenerationType.IDENTITY, we define this as primary key of this entity
 *  -> strategy=GenerationType.TABLE, we define the id generated for our entity will be stored in a table.
 *    @TableGenerator(name=A,table=B,pkColumnName=C,valueColumnName=D,allocationSize=E)  
 *    A: Table generator name
 *    B: Database table name where id will be stored
 *    C: primary key column name
 *    D: value column name
 *    E: by how much primary key should be incremented
 *  -> To generate our own primary key according to a strategy, we use custom generator
 *    @GenericGenerator(name=A,strategy=B) 
 *    	A: name of the generator
 *    	B: full class path of the generator class which implements IdentifierGenerator
 *    @GeneratedValue(generator=A)
 *      A: name of the generator
 *    
 */  	

@Entity
public class Employee {
	
	//@TableGenerator(name="employee_gen",table="id_gen",pkColumnName="gen_name",valueColumnName="gen_val",allocationSize=100)
	@GenericGenerator(name="emp_id_random_gen",strategy="com.prateek.springdata.idgenerators.generators.CustomRandomIDGenerator") 
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.TABLE,generator="employee_gen")
	@GeneratedValue(generator="emp_id_random_gen")
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
