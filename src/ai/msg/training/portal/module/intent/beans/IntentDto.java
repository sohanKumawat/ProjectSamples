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
@Table(name = "intent")
public class IntentDto implements Serializable {

	private static final long serialVersionUID = -7956305784515283305L;

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
	@Column(name = "topic")
	private String topic;
	@NotNull
	@Column(name = "type")
	private String type;

	@Column(name = "tags")
	private String tags;

	@Column(name = "entityTags")
	private String entityTags;
	@Column(name = "desc")
	private String desc;
	@Column(name = "status")
	private int status;

	@Column(name = "updatedBy")
	private String updatedBy;

	@NotNull
	@Column(name = "updatedOn")
	private Date updatedOn;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="intentName", nullable=true,referencedColumnName="name")//@JoinColumn(name="intentClassColumn", nullable=true,referencedColumnName="intentAttributeColumn")
	private List<IntentAttributes> intentAttributes ;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="intentName", nullable=true,referencedColumnName="name")//@JoinColumn(name="intentClassColumn", nullable=true,referencedColumnName="intentAttributeColumn")
	private List<Attributes> globalAttributes ;

	
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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getEntityTags() {
		return entityTags;
	}

	public void setEntityTags(String entityTags) {
		this.entityTags = entityTags;
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

	public List<IntentAttributes> getIntentAttributes() {
		return intentAttributes;
	}

	public void setIntentAttributes(List<IntentAttributes> intentAttributes) {
		this.intentAttributes = intentAttributes;
	}

	public List<Attributes> getGlobalAttributes() {
		return globalAttributes;
	}

	public void setGlobalAttributes(List<Attributes> globalAttributes) {
		this.globalAttributes = globalAttributes;
	}
}