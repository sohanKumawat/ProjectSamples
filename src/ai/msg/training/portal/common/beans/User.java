package ai.msg.training.portal.common.beans;


import java.io.Serializable;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session")
public class User implements Serializable{
	
	private static final long serialVersionUID = 13334444L;
	private Integer tenantUserId;
	private String firstName;
	private String lastName;
	private String loginId;
	private String email;
	private String status;
	private String imageUrl;
	private int tenantAccountId;

	private String AccountName;
	private String industryVertical;
	private String role;
	private String creationDate;
	private String updateDate;
	/*private boolean isLoggedIn;
	private boolean isLoggedOut;
	private long loginTime;
	private long loggedoutTime;
	private String clientId;*/
	
	public String getFirstName() {
		return firstName;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getTenantAccountId() {
		return tenantAccountId;
	}

	public void setTenantAccountId(int tenantAccountId) {
		this.tenantAccountId = tenantAccountId;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getIndustryVertical() {
		return industryVertical;
	}
	public void setIndustryVertical(String industryVertical) {
		this.industryVertical = industryVertical;
	}
	public Integer getTenantUserId() {
		return tenantUserId;
	}
	public void setTenantUserId(Integer tenantUserId) {
		this.tenantUserId = tenantUserId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
} 
