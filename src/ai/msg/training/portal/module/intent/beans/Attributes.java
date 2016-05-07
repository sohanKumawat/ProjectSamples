package ai.msg.training.portal.module.intent.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="attribute")
public class Attributes implements Serializable {

	private static final long serialVersionUID = 1921573769180365941L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotNull
	@Column(name = "tenantId")
	private String tenantId;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "scope")
	private String scope;

	@Column(name = "validValues")
	private String validValues;

	@NotNull
	@Column(name = "status")
	private int status;

	@Column(name = "desc")
	private String desc;

	@NotNull
	@Column(name = "updatedBy")
	private String updatedBy;
	
	@NotNull
	@Column(name = "updatedOn")
	private Date updatedOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getValidValues() {
		return validValues;
	}

	public void setValidValues(String validValues) {
		this.validValues = validValues;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	
	
}

