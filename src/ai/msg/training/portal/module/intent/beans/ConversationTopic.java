package ai.msg.training.portal.module.intent.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="topic")
public class ConversationTopic implements Serializable{
	
	private static final long serialVersionUID = -4430451854494288413L;
	
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

	@Column(name = "desc")
	private String desc;
	
	@Column(name = "status")
	private int status;
	
	@NotNull
	@Column(name = "updatedBy")
	private String updatedBy;
	
	@Column(name = "updatedOn")
	private Date updatedOn;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="topic", nullable=true,referencedColumnName="name")//@JoinColumn(name="intentClassColumn", nullable=true,referencedColumnName="intentAttributeColumn")
	private List<IntentDto> topicIntent ;
	
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


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
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

	

	public List<IntentDto> getTopicIntent() {
		return topicIntent;
	}


	public void setTopicIntent(List<IntentDto> topicIntent) {
		this.topicIntent = topicIntent;
	}


	@Override
	public String toString() {
		return "ConversationTopic [id=" + id + ", tenantId=" + tenantId + ", name=" + name + ", desc=" + desc
				+ ", status=" + status + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", topicIntent="
				+ topicIntent + "]";
	}
}
