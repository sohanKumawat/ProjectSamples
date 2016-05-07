package ai.msg.training.portal.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ai.msg.training.portal.restclient.config.SocialApiConfig;
 
@Component
public class SocialRestUrlCreator {

	@Autowired
	SocialApiConfig socialApiConfig;
	
	
	public String getSocialAPIUrl(String ApiType){
		String serviceUrl="http://"+socialApiConfig.getHostName()+":"+socialApiConfig.getPortNumber()+"/"+socialApiConfig.getContextPath()+"/";
		switch(ApiType){
		
		case "stopService" :
			serviceUrl+=socialApiConfig.getApiUrls().get("stopService");
			break;
		case "startService":
			serviceUrl+=socialApiConfig.getApiUrls().get("startService");
			break;
		
		case "validConfig" :
			serviceUrl+=socialApiConfig.getApiUrls().get("validConfig");
			break;
			
		case "allActiveList" :
			serviceUrl+=socialApiConfig.getApiUrls().get("allActiveList");
			break;
		}
		return serviceUrl;
	}
	
	
}
