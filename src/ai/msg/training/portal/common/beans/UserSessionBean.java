package ai.msg.training.portal.common.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import ai.msg.training.portal.common.beans.User;

@Component
@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Autowired
	Tenant tenant;
	
	@Autowired
	User user;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
