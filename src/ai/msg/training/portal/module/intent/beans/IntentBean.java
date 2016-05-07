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

/**
*
* @author Sohan Kumawat
*/
@Entity
@Table(name = "queryIntent")
public class IntentBean implements Serializable {
	private static final long serialVersionUID = -5471935424316244806L;

	//@Id
	//@GeneratedValue(generator = "queryIntent.intent_id", strategy=GenerationType.TABLE)
  //  @TableGenerator(name = "queryIntent.intent_id", pkColumnName="queryIntent.intent_id",table = "queryIntent", allocationSize = 10)
/*	
	 @TableGenerator(name="USER_GENERATOR",
     table="queryIntent",
     pkColumnName="intentName",
     valueColumnName="intent_id",
     pkColumnValue="queryIntent.intentName",
     allocationSize=1
)*/
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "intent_id")
	private int intent_id;

	@NotNull
	@Column(name = "intentName")
	private String intentName;
	
	@NotNull
	@Column(name = "tenantId")
	private String tenantId;
	
	@Column(name = "intent_desc")
	private String intent_desc;
	
	@Column(name = "intent_topic")
	private String intent_topic;
	
	@Column(name = "intent_topic_desc")
	private String intent_topic_desc;
	
	@Column(name = "createdTime")
	private Date createdTime;
	
	@Column(name = "updatedTime")
	private Date updatedTime;
	
	@Column(name="intentExpression")
	private String intentMasterExpression;
	

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="intentName", nullable=true,referencedColumnName="intentName")//@JoinColumn(name="intentClassColumn", nullable=true,referencedColumnName="intentAttributeColumn")
	private List<IntentAttributes> intentAttribute ;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="intentName", nullable=true,referencedColumnName="intentName")//@JoinColumn(name="intentClassColumn", nullable=true,referencedColumnName="intentAttributeColumn")
	private List<IntentChildExpression> subExpression ;

	

	public int getIntent_id() {
		return intent_id;
	}

	public void setIntent_id(int intent_id) {
		this.intent_id = intent_id;
	}

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getIntent_desc() {
		return intent_desc;
	}

	public void setIntent_desc(String intent_desc) {
		this.intent_desc = intent_desc;
	}

	public String getIntent_topic() {
		return intent_topic;
	}

	public void setIntent_topic(String intent_topic) {
		this.intent_topic = intent_topic;
	}

	public String getIntent_topic_desc() {
		return intent_topic_desc;
	}

	public void setIntent_topic_desc(String intent_topic_desc) {
		this.intent_topic_desc = intent_topic_desc;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	
	
/*	 @OneToMany(cascade=CascadeType.ALL) 
 * 
 @JoinTable annotation is used to join two table using a third table. This third table associates two table by their Ids. To define @JoinTable we can use below attributes. 
      name: This is the name of third table. 
      joinColumns:entity itself. 
      inverseJoinColumns: third table column.

	    @JoinTable(name="user_roles",  
	    joinColumns={@JoinColumn(name="role_id", referencedColumnName="id")},  
	    inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")}) 
	    */
	
	public String getIntentMasterExpression() {
		return intentMasterExpression;
	}

	public void setIntentMasterExpression(String intentMasterExpression) {
		this.intentMasterExpression = intentMasterExpression;
	}

	public List<IntentAttributes> getIntentAttribute() {
		return intentAttribute;
	}

	public void setIntentAttribute(List<IntentAttributes> intentAttribute) {
		this.intentAttribute = intentAttribute;
	}

	public List<IntentChildExpression> getSubExpression() {
		return subExpression;
	}

	public void setSubExpression(List<IntentChildExpression> subExpression) {
		this.subExpression = subExpression;
	}

}
