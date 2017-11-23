package com.app.aop.onstarter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.app.aop.model.Account;
import com.app.aop.service.ExampleService;

@Component
public class StartupApplicationListener {
   	 public static int counter;
   	 
@Autowired
ExampleService exampleService;
   	 
	    @EventListener
	    public void onApplicationEvent(ContextRefreshedEvent event) {
	        counter++;

	    	Account account = new Account("000001", "Account 1");
	    	exampleService.updateAccountBalance(account, 100L);

	    	List<Account> accounts = exampleService.findCustomerAccounts(1L);
             System.out.println("after findCustomerAccounts ** account class "+accounts.toString());
	    	account.setAccountDescription("Test Description");
	    Account act=	exampleService.updateAccountDescription(account);
	        System.out.println("after updateAccountDescription ** exampleService "+act.toString());
	    	exampleService.methodUsingGenerics(account);
	    }
}
