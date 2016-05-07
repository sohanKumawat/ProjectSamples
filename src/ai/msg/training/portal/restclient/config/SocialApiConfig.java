package ai.msg.training.portal.restclient.config;

import java.util.Map;

public class SocialApiConfig {

	
	private String hostName;
	private String portNumber;
	private String contextPath;
	private Map<String,String> ApiUrls;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public Map<String, String> getApiUrls() {
		return ApiUrls;
	}
	public void setApiUrls(Map<String, String> apiUrls) {
		ApiUrls = apiUrls;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	
	
}
