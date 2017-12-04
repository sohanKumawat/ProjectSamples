package com.app.aop.onstarter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.app.aop.model.Account;
import com.app.aop.service.AccountService;

@Component
public class StartupApplicationListener {
   	 public static int counter;
   	 
@Autowired
AccountService accountService;
   	 
	    @EventListener
	    public void onApplicationEvent(ContextRefreshedEvent event) {
	        counter++;

	    	Account account = new Account("000001", "Account 1");
	    	accountService.updateAccountBalance(account, 100L);

	    	List<Account> accounts = accountService.findCustomerAccounts(1L);
             System.out.println("after findCustomerAccounts ** account class "+accounts.toString());
	    	account.setAccountDescription("Test Description");
	   /* Account act=	accountService.updateAccountDescription(account);
	        System.out.println("after updateAccountDescription ** accountService "+act.toString());
	    	accountService.methodUsingGenerics(account);*/
	    }
}
