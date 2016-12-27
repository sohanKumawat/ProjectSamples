package ai.msg.rest.api.controller;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ai.msg.security.auth.JwtAuthenticationToken;
import ai.msg.security.model.UserContext;

@RequestMapping(value="api/analytics")
@RestController
public class AnalyticsController {
	
	public AnalyticsController(){
		
	}
	@RequestMapping(value="/dashboard",method={RequestMethod.GET,RequestMethod.POST})
/*	public @ResponseBody String fetchAnalyticsData(ServletServerHttpRequest request){
		System.out.println("Input Json");
		return "";
	}*/
	 public @ResponseBody UserContext get(JwtAuthenticationToken token) {
	        return (UserContext) token.getPrincipal();
	    }
}
