package com.app.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.app.aop.model.Account;

@Aspect
@Component
public class AccountLoggingAspect {

	@Before(value = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && " + "args(account,..)")
	public void beforeAccountMethodExecution(Account account) {
		System.out.println("Logging account access. Account: " + account.getAccountNumber());
	}

	@Before(value = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && " + "args(account,..)")
	public void beforeAccountMethodExecution(JoinPoint jp, Account account) {

		System.out.println("beforeAccountMethodExecution: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());

		System.out.println("Logging account access. Account: " + account.getAccountNumber());
	}

	@Before(value = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && " + "args(account,amount)")
	public void beforeAccountMethodExecution(JoinPoint jp, Account account, Long amount) {

		System.out.println("inside the beforeAccountMethodExecution. Account: " + account.getAccountNumber()
				+ ", Amount: " + amount);
	}

	@Before(value = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && "
			+ "args(account,..) && @annotation(auditable)")
	public void audit(Account account, Auditable auditable) {
		System.out.println(
				"Audit account access: " + account.getAccountNumber() + ". Audit destination: " + auditable.value());
	}

	@Before(value = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && "
			+ "execution(java.util.List<com.app.aop.model.Account> find*(..)) && " + "args(customerId,..)")
	public void beforeAcountFinder(Long customerId) {
		System.out.println("Logging access to account finder. CustomerID: " + customerId);
	}

	@Around(value = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && "
			+ "execution(* com.app.aop.service.ExampleService.updateAccountDescription(..)) && " + "args(account)")
	public Account beforeUpdateAccountDescription(ProceedingJoinPoint pjp, Account account) throws Throwable {
		System.out.println("Account description" + account.getAccountDescription().toUpperCase());
		account.setAccountDescription(account.getAccountDescription().toUpperCase() + "new description");
		System.out.println("Logging access to updateAccountDescription. Prepared account description: "
				+ account.getAccountDescription());

		Account rAccount = (Account) pjp.proceed(new Object[] { account });

		rAccount.setAccountDescription("new account description");
		return rAccount;
	}

	@Before(value = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && "
			+ "execution(* com.app.aop.service.ExampleService.methodUsingGenerics(..)) && " + "args(parameter)")
	public void beforeGenericMethod(Account parameter) {
		System.out.println("Logging access to generic method. Account: " + parameter.getAccountNumber());
	}

	@AfterReturning(pointcut = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && "
			+ "execution(java.util.List<com.app.aop.model.Account> find*(..)) && " + "args(customerId,..)",returning="accounts"
			)
	public void afterAcountFinder(JoinPoint joinPoint, Long customerId,List<Account> accounts) {
		System.out.println("Logging access to account finder. CustomerID: " + customerId);
		System.out.println(" findCustomerAccounts Method response : " + joinPoint);
		
		System.out.println(" All the account according the customer id is  : " + accounts.toString());
	}

	@AfterThrowing(pointcut = "com.app.aop.aspect.PointcutDefinition.serviceLayer() && "
			+ "execution(java.util.List<com.app.aop.model.Account> find*(..))", throwing = "ex")
	public void doRecoveryActions(Exception ex) {
		System.out.println("Throwing exception from findCustomerAccounts method ** " + ex.getMessage());
	}

}
