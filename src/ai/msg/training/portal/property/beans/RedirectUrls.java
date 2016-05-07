package ai.msg.training.portal.property.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



@Service
@Scope("singleton")
public class RedirectUrls {

	@Value("${loggedInRestrictedUrls}")
	private List<String> loginRestrictedUrls;
	
	@Value("${LoggedOutRedirectionUrls}")
	private String loggedOutRedirectionUrls;
	
    @Value("${loggedInRedirectionUrl}")
	private String loggedInRedirectionUrl;
    
    @Value("${allowedUrls}")
    private List<String> allowedUrls;

	
	public List<String> getLoginRestrictedUrls() {
		
		return loginRestrictedUrls;
	}

	public void setLoginRestrictedUrls(List<String> loginRestrictedUrls) {
		this.loginRestrictedUrls = loginRestrictedUrls;
	}

	public String getLoggedOutRedirectionUrls() {
		return loggedOutRedirectionUrls;
	}

	public void setLoggedOutRedirectionUrls(String loggedOutRedirectionUrls) {
		this.loggedOutRedirectionUrls = loggedOutRedirectionUrls;
	}

	public String getLoggedInRedirectionUrl() {
		return loggedInRedirectionUrl;
	}

	public void setLoggedInRedirectionUrl(String loggedInRedirectionUrl) {
		this.loggedInRedirectionUrl = loggedInRedirectionUrl;
	}

	public List<String> getAllowedUrls() {
		return allowedUrls;
	}

	public void setAllowedUrls(List<String> allowedUrls) {
		this.allowedUrls = allowedUrls;
	}

	

	/*public List<String> getLoginRestrictedUrlsAsList(){
		
	if(this.loggedInRedirectionUrl!=null){
	 String[] loginRestrictedUrlsAsList=	loginRestrictedUrls.split(",");
	  return	Arrays.asList(loginRestrictedUrlsAsList);
	}
		return null;	
	}

	public void setLoginRestrictedUrls(String loginRestrictedUrls) {
		this.loginRestrictedUrls = loginRestrictedUrls;
	}

	public void setLoggedOutRedirectionUrls(String loggedOutRedirectionUrls) {
		this.loggedOutRedirectionUrls = loggedOutRedirectionUrls;
	}

	public void setLoggedInRedirectionUrl(String loggedInRedirectionUrl) {
		this.loggedInRedirectionUrl = loggedInRedirectionUrl;
	}*/
	
	/*public List<String> getLoggedOutRestrictedUrlsAsList(){
		
		if(this.loggedOutRedirectionUrls!=null){
		 String[] loggedOutRedirectionUrlsAsList=	loggedOutRedirectionUrls.split(",");
		  return	Arrays.asList(loggedOutRedirectionUrlsAsList);
		}
			return null;	
	}*/
	
	
	
	
}
