package com.wise.database.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wise.database.springdatabase.entity.Person;
import com.wise.database.springdatabase.jdbc.PersonJdbcDao;

@SpringBootApplication
public class SpringDatabaseApplication implements CommandLineRunner{
	
	@Autowired
	PersonJdbcDao dao;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args){
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.findAll();
		logger.info("All users -> {}",dao.findAll());
		logger.info("User id 10001 -> {}",dao.findById(10002));
		logger.info("User location ajax -> {}",dao.findByLocation("Ajax"));
		
		logger.info("Deleting id 10002 -> {}",dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}", 
				dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		
		logger.info("Update 10003 -> {}", 
				dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));

	}

}

