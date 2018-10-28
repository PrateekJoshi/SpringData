package com.prateek.springdata.idgenerators.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/*
 * Our own custom primary key id generator
 */

public class CustomRandomIDGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Random random = new Random();
		int id = random.nextInt(1000000);		
		return new Long(id);					//since our id filed is Long, we return Long
	}
	
	
}
