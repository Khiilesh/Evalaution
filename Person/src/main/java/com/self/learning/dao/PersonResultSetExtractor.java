package com.self.learning.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.self.learning.model.Person;

public class PersonResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setName(rs.getString(1));
        person.setAge(rs.getInt(2));
        person.setDateOfBirth(rs.getDate(3));
        person.setEmailAddress(rs.getString(4));
        return person;
    }

}