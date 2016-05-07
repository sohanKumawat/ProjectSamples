package ai.msg.training.portal.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ai.msg.training.portal.common.beans.Tenant;
import ai.msg.training.portal.common.beans.User;
import ai.msg.training.portal.common.beans.UserSessionBean;

@Controller
public class BaseController {

	@Autowired
	UserSessionBean userSessionBean;

	
	public final Tenant getTenant(){
		return this.userSessionBean.getTenant();
	}
	
	public final User getTenantUser(){
		return this.userSessionBean.getUser();
		
	}
	
	public final int getUserId(){
		
		return this.userSessionBean.getUser().getTenantUserId();
		
		//return 0;
	}
	
	public final String getTenantId(){
		return this.userSessionBean.getTenant().getAccountId();
	}
	
}
