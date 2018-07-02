package com.self.learning.dao;

import java.util.HashMap;
import java.util.Map;

import com.self.learning.model.Person;

public enum PersonDao {

	instance;

	private Map<String, Person> contentProvider = new HashMap<>();

	private PersonDao() {

		Person person1 = new Person("Name1", 26, new java.util.Date(System.currentTimeMillis()), "name1@abc.com");
		Person person2 = new Person("Name2", 62, new java.util.Date(System.currentTimeMillis()), "name2@xyz.com");

		contentProvider.put("Name1", person1);
		contentProvider.put("Name2", person2);

	}

	public Map<String, Person> getModel() {
		return contentProvider;
	}

}
