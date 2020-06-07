package com.example.demo.config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class CommonPointCutConfigs {

	@Pointcut(value = "execution(* com.example.demo.services.*.*(..))")
	public void dataLayerExecution(){}
	
         @Pointcut(value ="within(com.example.demo.domains.*)")
         public void usingWithin() {}
         
         
         @Pointcut(value ="target(com.training.ifaces.Converter)")
         public void usingTarget() {}
         

         @Pointcut(value ="args(Double,String)")
         public void usingMethodArgs() {}
         

         @Pointcut(value ="execution(* com.example.demo.services.*.*(..)) "
         		+ "&& args(com.example.demo.domains.City)")
         public void usingConditions() {
        	 
         }

         @Pointcut(value = "execution(com.example.demo.domains.Weather com.example.demo.services.*.*(..))")
         public void afterReturn() {
        	 
         }



}	







