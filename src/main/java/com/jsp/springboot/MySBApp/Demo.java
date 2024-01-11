package com.jsp.springboot.MySBApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Demo {

	//first way to access the key and value from the properties file
	@Value("${my.name.is}")
	public String name;
	
	//Second way to access the key and value from the properties file
	@Autowired
	public Environment env;
	
	public void display() {
		System.out.println(name);
		System.out.println("From the Environment "+ env.getProperty("my.name.is"));
	}
}
