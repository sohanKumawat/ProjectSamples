package ai.msg.training.portal.module.intent.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conversation_entity")
public class ConversationEntityBean {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "entity_id")
	private int entity_id;

	public int getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(int entity_id) {
		this.entity_id = entity_id;
	}

	
	
}
