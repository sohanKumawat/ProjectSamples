package ai.msg.training.portal.settings.social.bean;

import java.io.Serializable;

public class SocialConfigParameter implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1347546765342513697L;
	private String configParameter;
	private String configValue;
	private int status;
	
	public SocialConfigParameter(){
		
	}
	
	public SocialConfigParameter(String configParameter,String configValue,int status){
		this.configParameter=configParameter;
		this.configValue=configValue;
		this.status=status;
	}

	public String getConfigParameter() {
		return configParameter;
	}

	public void setConfigParameter(String configParameter) {
		this.configParameter = configParameter;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
