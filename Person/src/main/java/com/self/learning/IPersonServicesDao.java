package com.self.learning;

import java.io.Serializable;
import java.util.List;

/*public interface PersonServicesDao {

	
	public List<Person> getPersonList();
	public boolean insertPerson(Person person);
	public Person getPerson(String personName);
    public boolean updatePerson(Person person);
	public boolean deletePerson(Person person);
	  
	 
	
}*/


public interface IPersonServicesDao<T extends Serializable> {

	List<T> findAll();

	int create(final T entity);

	T findOne(final String id);

	T update(final T entity);
	
	int deleteById(final String entityId);
}