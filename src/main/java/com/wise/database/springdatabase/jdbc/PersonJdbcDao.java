package com.wise.database.springdatabase.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wise.database.springdatabase.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// select * from person
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
		
	}
	
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from person where id=?",  
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
		
	}
	
	public int deleteById(int id){
		 return jdbcTemplate.update("delete from person where id=?",  
				new Object[] {id});
		
	}
	
	public List<Person> findByLocation(String location){
		return jdbcTemplate.query("select * from person where location=?",  
				new Object[] {location},
				new BeanPropertyRowMapper<Person>(Person.class));
		
	}

}
