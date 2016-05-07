package ai.msg.training.portal.common.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class TenantUser implements Serializable{

	private static final long serialVersionUID = 4163918310792713978L;
	private Integer tenantUserId;
	private Integer accountId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String loginId;
	private String password;
	private String status;
	private Date creationDate;
	private Date updateDate;
	private String role;
	
	
	public Integer getTenantUserId() {
		return tenantUserId;
	}
	public void setTenantUserId(Integer tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
