package ai.msg.training.portal.restclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import ai.msg.training.portal.settings.social.bean.SocialConfigParameter;

@Service
public class SocialRestClient {

	private static org.slf4j.Logger LOGGER  =  LoggerFactory.getLogger(SocialRestClient.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	SocialRestUrlCreator socialRestUrlCreator;
	
	public String checkForSocialCredential(String tenantId,String platform,String[] configParam) throws Exception{
		String url= this.socialRestUrlCreator.getSocialAPIUrl("validConfig");
		LOGGER.debug("URL for service checkconfigValid is {}",url);
		
		MultiValueMap<String, Object> mapping = new LinkedMultiValueMap<String, Object>();
		 
	//	String[] configParam = new String[10];
		    int i=0;
		    for (i=0;i<configParam.length;i++)
			{	
		    	mapping.add("platformConfig", configParam[i]);//configParam[i]=entry.getValue().getConfigParameter()+"|"+entry.getValue().getConfigValue();
		    	
			}
		mapping.add("clientId", tenantId);
		mapping.add("platform", platform);
	    String result= this.restTemplate.postForObject( url, mapping,String.class);
	    return result;	
	}
	
	public String startSocialService(String tenantId,String platform,String direction) throws Exception{
		String url= this.socialRestUrlCreator.getSocialAPIUrl("startService");
		LOGGER.debug("service for start service is {}",url);
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("clientId", tenantId);
		map.add("platform",platform);
		map.add("direction",direction);
		//RestTemplate restTemplate = new RestTemplate();
	    String result= this.restTemplate.postForObject( url, map,String.class);
	    return result;
	}
	
	public String stopSocialService(String tenantId,String platform,String direction) throws Exception{
		String url= this.socialRestUrlCreator.getSocialAPIUrl("stopService");
		LOGGER.debug("service for stop service {} with direction {}",url,direction);
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		//	Map<String,String> map=new HashMap<String,String>();
			map.add("clientId", tenantId);
			map.add("platform",platform);
			map.add("direction",direction);
	    String result= this.restTemplate.postForObject( url, map,String.class);
	    return result;
	}
	
	
	public String getActiveServices(String clientId) throws Exception{
		String url= this.socialRestUrlCreator.getSocialAPIUrl("allActiveList");
		LOGGER.debug("service for getActiveServices {}",url);
		url=url.replace("{clientId}", clientId);
	    String result= this.restTemplate.getForObject( url,String.class);
	    return result;
	}
	
}
