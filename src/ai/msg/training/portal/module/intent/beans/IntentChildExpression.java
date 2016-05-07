package ai.msg.training.portal.module.intent.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * Author sohan kumawat
 * 
 */

@Entity
@Table(name="intentSubExpression")
public class IntentChildExpression implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	
	@NotNull
	@Column(name="intentName")
	private String intentName;
	
	@NotNull
	@Column(name="tenantId")
	private String tenantId;
	
	@NotNull
	@Column(name="expressionText")
	private String expressionText;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getExpressionText() {
		return expressionText;
	}

	public void setExpressionText(String expressionText) {
		this.expressionText = expressionText;
	}

}
