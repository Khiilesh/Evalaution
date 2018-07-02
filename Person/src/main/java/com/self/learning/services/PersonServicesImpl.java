package com.self.learning.services;

import java.io.Serializable;
import java.util.List;

import com.self.learning.IPersonServicesDao;
import com.self.learning.dao.QueryExecutor;
import com.self.learning.model.Person;

@SuppressWarnings("rawtypes")
public class PersonServicesImpl implements IPersonServicesDao {

	private QueryExecutor queryExecutor;

	@Override
	public List<Person> findAll() {
		List<Person> listOfPerson = queryExecutor.selectAll();
		return listOfPerson;
	}

	@Override
	public int create(Serializable entity) {

		return queryExecutor.insertPerson((Person) entity);
	}

	@Override
	public Serializable findOne(String id) {
		return (Serializable) queryExecutor.select(id);
	}

	@Override
	public Serializable update(Serializable entity) {
		return (Serializable) queryExecutor.updatePerson((Person) entity);

	}

	@Override
	public int deleteById(String entityId) {
		return queryExecutor.delete(entityId);

	}

}
