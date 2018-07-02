package com.self.learning.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.self.learning.model.Person;

public class QueryExecutor {

	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	@SuppressWarnings("unchecked")
	public List<Person> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select NAME, AGE, DOB, EMAILID from PERSON", new PersonRowMapper());
	}

	public int insertPerson(Person person) {

		JdbcTemplate insert = new JdbcTemplate(dataSource);

		String personName = person.getName();
		int age = person.getAge();
		Date dob = person.getDateOfBirth();
		String emailID = person.getEmailAddress();

		return insert.update("INSERT INTO PERSON (NAME, AGE, DOB, EMAILID) VALUES(?,?)",
				new Object[] { personName, age, dob, emailID });

	}

	@SuppressWarnings("unchecked")
	public List<Person> select(String name) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select  NAME, AGE, DOB, EMAILID FROM PERSON where NAME = ? ", new Object[] { name },
				new PersonRowMapper());
	}

	public int updatePerson(Person person) {

		JdbcTemplate insert = new JdbcTemplate(dataSource);

		int age = person.getAge();
		Date dob = person.getDateOfBirth();
		String emailID = person.getEmailAddress();

		return insert.update("INSERT INTO PERSON (NAME, AGE, DOB, EMAILID) VALUES(?,?)",
				new Object[] { age, dob, emailID });

	}

	public int delete(String name) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
		return delete.update("DELETE from PERSON where NAME= ?", new Object[] { name });
	}

}
