package ai.msg.training.portal.common.beans;

import java.util.List;


public class RedirectUrls {

	private List<String> loginRestrictedUrls;
	private List<String> nonLoginRestrictedUrls;
	
	public List<String> getLoginRestrictedUrls() {
		return loginRestrictedUrls;
	}
	public void setLoginRestrictedUrls(List<String> loginRestrictedUrls) {
		this.loginRestrictedUrls = loginRestrictedUrls;
	}
	public List<String> getNonLoginRestrictedUrls() {
		return nonLoginRestrictedUrls;
	}
	public void setNonLoginRestrictedUrls(List<String> nonLoginRestrictedUrls) {
		this.nonLoginRestrictedUrls = nonLoginRestrictedUrls;
	}
	
}
