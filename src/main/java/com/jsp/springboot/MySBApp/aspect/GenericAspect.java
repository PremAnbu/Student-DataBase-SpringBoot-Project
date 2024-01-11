package com.jsp.springboot.MySBApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jsp.springboot.MySBApp.controller.StudentController;

@Aspect
@Component
public class GenericAspect {
    
	//First * => it will specify the return type eg => ResponseBody
	// give some space and give the fully qualified class name
	//second *=> any class in the controller package
	//Third * => any method in the controller class
	//(..) => with parameter or without parameter or more the one also
	
	//joinPoint => the current method executing
	
	@Pointcut("execution(*  com.jsp.springboot.MySBApp.controller.*.*(..))")
	public void logger() {
	};
	
	@Before("logger()")
	public void beforeExecution(JoinPoint jp) {
		System.out.println("************ Before method Invokation ************" + jp.getSignature());
	}

}
