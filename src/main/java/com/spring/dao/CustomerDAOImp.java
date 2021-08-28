package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Customer;

@Repository
public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		Session cuurentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> query = cuurentSession.createQuery("FROM customer", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
