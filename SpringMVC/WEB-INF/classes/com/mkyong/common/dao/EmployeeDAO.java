package com.mkyong.common.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.common.model.Employee;


@Repository
@Transactional
public class EmployeeDAO {
	
	  
	 @Autowired  
	 private SessionFactory sessionFactory;  
	   
	 public Employee getById(int id)  
	 {  
	  return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);  
	 }  
	   
	 @SuppressWarnings("unchecked")  
	 public List<Employee> searchContacts(String name)  
	 {  
	  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);  
	  criteria.add(Restrictions.ilike("name", name+"%"));  
	  return criteria.list();  
	 }  
	   
	 @SuppressWarnings("unchecked")  
	 public List<Employee> getALLEmployees()  
	 {  
	  Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);  
	  return criteria.list();  
	 }  
	   
	 public int save(Employee contact)  
	 {  
	  return (Integer) sessionFactory.getCurrentSession().save(contact);  
	 }  
	   
	 public void update(Employee contact)  
	 {  
	  sessionFactory.getCurrentSession().merge(contact);  
	 }  
	   
	 public void delete(int id)  
	 {  
		 Employee c = getById(id);  
	  sessionFactory.getCurrentSession().delete(c);
	  
	  
	 }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}  
	  

}
