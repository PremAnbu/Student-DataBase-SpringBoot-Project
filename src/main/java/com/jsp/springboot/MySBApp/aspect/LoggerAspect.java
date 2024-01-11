package com.jsp.springboot.MySBApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	Logger log;

	// first way
    //@Pointcut("execution(*  com.jsp.springboot.MySBApp.controller.*.* (..))")

	// second way  => to count how many sub packages are present in the controller
	// package to mention that any stars
	@Pointcut("execution(*  *.*.*.*.controller.*.* (..))")
	public void controllerLogs() {
	};

	@Before("controllerLogs()")
	public void boforeController(JoinPoint joinPoint) {
		log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
		log.info("Invoked : " + joinPoint.getSignature());

	}

	@After("controllerLogs()")
	public void afterController(JoinPoint joinPoint) {
		log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
		log.info("Exited : " + joinPoint.getSignature());
	}
	
	//=======================
	@Pointcut("execution(*  *.*.*.*.service.*.* (..))")
	public void serviceLogs() {
	};

	@AfterThrowing("serviceLogs()")
	public void afterService(JoinPoint joinPoint) {
		log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
		log.error("Throw Exception from: " + joinPoint.getSignature());
	}
	
	//=================================
	
	//breaf information of exception 
	
	//@Pointcut("execution(*  com.jsp.springboot.MySBApp.service.utility.ApplicationExceptionHandler.* (..))")

	@Pointcut("execution(*  *.*.*.*.utility.ApplicationExceptionHandler.* (..))")
	public void adviseLogs() {
	};

	@Before("adviseLogs()")
	public void logAfterHandlerMethodInvocation(JoinPoint joinPoint) {
		Exception ex=(Exception) joinPoint.getArgs()[0];
		
		log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
		log.error(ex.getMessage());
		log.error("Accourret line  : " +ex.getStackTrace()[0].getLineNumber() );
	}
	
}
