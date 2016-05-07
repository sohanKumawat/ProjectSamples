package ai.msg.training.portal.daoImpl;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.msg.training.portal.module.intent.beans.ConversationTopic;

@Repository
@Transactional
public interface TopicRepository extends JpaRepository<ConversationTopic, String> {

	
	
}
