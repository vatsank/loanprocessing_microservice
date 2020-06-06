package com.example.demo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.domains.City;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class CustomAspect {

    @Around("com.example.demo.config.CommonPointCutConfigs.dataLayerExecution()")
    

    
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj =joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Time Taken by {} is {}"+ joinPoint+","+ timeTaken);
	
		  return obj;
    }

    @Before("com.example.demo.config.CommonPointCutConfigs.usingWithin()")
    public void before(JoinPoint joinPoint) throws Throwable{
    
    	System.out.println(joinPoint.getTarget() +"," +joinPoint.getSignature());
    }
    
    
    @After("com.example.demo.config.CommonPointCutConfigs.usingTarget()")
    public void after(JoinPoint joinPoint) throws Throwable{
    
    	log.info("After ==="+joinPoint.getTarget() +"," +joinPoint.getSignature());
    }
    
    
    @After("com.example.demo.config.CommonPointCutConfigs.usingMethodArgs()")
    public void afterWithArgs(JoinPoint joinPoint) throws Throwable{
    
    	log.info("Method Args ****"+joinPoint.getTarget() +"," +joinPoint.getSignature());
    }
    
    
    
    @Before("com.example.demo.config.CommonPointCutConfigs.usingConditions()")
    public void conditionalBefore(JoinPoint joinPoint) throws Throwable{
    
    	log.info("conditional &&&&->"+joinPoint.getTarget() +"," +joinPoint.getSignature());
    	

    	

    	Arrays.asList(joinPoint.getArgs()).stream().forEach(System.out::println);
    	
    	
    }
    
    
    
}
