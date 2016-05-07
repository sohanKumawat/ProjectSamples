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
@Table(name = "prompt")
public class Prompt implements Serializable {

private static final long serialVersionUID = 3897910098994157485L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;
@NotNull
@Column(name = "tenantId")
private String tenantId;

@NotNull
@Column(name = "question")
private String question;

@NotNull
@Column(name = "type")
private String type;

@Column(name = "state")
private String state;

@Column(name = "parentPromptId")
private String parentPromptId;
@Column(name = "desc")
private String desc;
@NotNull
@Column(name = "status")
private int status;
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
public String getQuestion() {
return question;
}
public void setQuestion(String question) {
this.question = question;
}
public String getType() {
return type;
}
public void setType(String type) {
this.type = type;
}
public String getState() {
return state;
}
public void setState(String state) {
this.state = state;
}
public String getParentPromptId() {
return parentPromptId;
}
public void setParentPromptId(String parentPromptId) {
this.parentPromptId = parentPromptId;
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

}
