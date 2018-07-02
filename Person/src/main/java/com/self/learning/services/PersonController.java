package com.self.learning.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.self.learning.dao.PersonDao;
import com.self.learning.model.Person;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@RestController
public class PersonController {

	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int UNPROCESSABLE_ENTITY = 422;

	private PersonServicesImpl personServices;

	// 1. URI: /people

	@RequestMapping(value = "/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Person> getList() {

		List<Person> personList = new ArrayList<Person>();

		try {
			personList = personServices.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return personList;

	}

	// 2. URI: /people
	@RequestMapping(value = "/people", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public Person addPeople(@RequestBody Person requestBody) {
		try {
			personServices.create(requestBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestBody;
	}

	// 3. URI: /people/{:id}
	@RequestMapping(value = "/people/{:id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("personName") String id) {
		Person sortedPerson = null;
		try {
			sortedPerson = (Person) personServices.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sortedPerson;
	}

	// 4. URI: /people/{:id}
	@RequestMapping(value = "/people", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Person updatePerson(@RequestBody Person requestBody) {
		try {
			personServices.update(requestBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestBody;
	}

	// 5. URI: /people/{:id}
	@RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
	public int deletePerson(@PathVariable("personName") String id) {
		int exitCode = 0;
		try {
			exitCode = personServices.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exitCode;
	}

}
