package com.jsp.springboot.MySBApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jsp.springboot.MySBApp")
public class MySbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySbAppApplication.class, args);
		System.out.println("Ran Successfully !!!");
	}

}
