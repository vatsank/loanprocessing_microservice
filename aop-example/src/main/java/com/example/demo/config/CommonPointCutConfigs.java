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

         



}	



//AOP advice intercepted method name and return type
//We may also define advices that are based on the intercepted method return type and/or method name.

//Consider the following advice:
//
//@Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
//  + "execution(java.util.List<com.byteslounge.model.Account> find*(..)) && "
//  + "args(customerId,..)")
//public void beforeAcountFinder(Long customerId) {
//  System.out.println("Logging access to account finder. CustomerID: "
//    + customerId);
//}
//This advice will target methods in the service layer which:
//
//Return type is List<Account>
//Method name starts with find
//The first method parameter name is customerId with Long type
//If we hold a reference to our example service bean and call:
//
//List<Account> accounts = exampleService.findCustomerAccounts(1L);

		
//		Passing parameters to AOP advices
//		In Spring AOP it is possible to pass parameters from the intercepted method into the advice.
//
//		Let's define an advice:
//
//		Account Logging Aspect
//		@Aspect
//		public class AccountLoggingAspect {
//
//		  @Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
//		    + "args(account,..)")
//		  public void beforeAccountMethodExecution(Account account) {
//		    System.out.println("Logging account access. Account: "
//		      + account.getAccountNumber());
//		  }
//
//		}
