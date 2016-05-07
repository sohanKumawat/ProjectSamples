package ai.msg.training.portal.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ai.msg.training.portal.module.dashboard.beans.DashboardDetailsBean;

@Controller
public class DashboardController extends BaseController{
	
	@RequestMapping(value="/fetchDeshboardDetails",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody DashboardDetailsBean fetchDeshboardDetails(@RequestBody DashboardDetailsBean dbBean){
		
		DashboardDetailsBean bean=new DashboardDetailsBean();
		
		return dbBean;
		
	}

}
