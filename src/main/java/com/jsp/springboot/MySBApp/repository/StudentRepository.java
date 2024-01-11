package com.jsp.springboot.MySBApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.MySBApp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	
	//user defined method
	public Optional<Student> findByName(String sName);
	
	
	//public List<Product> findByBrandByPrice(String brand,double price);
	
	//(or)
	
	//@Query("From Product p where p.brand=?1 and p.price=?2")
	//public List<Product> findByBrandByPrice(...);
	
		
	}
