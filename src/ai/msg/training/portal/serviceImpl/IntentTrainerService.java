package ai.msg.training.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.msg.training.portal.common.beans.HttpRequestSataus;
import ai.msg.training.portal.daoImpl.AttributeAssociationRepository;
import ai.msg.training.portal.daoImpl.AttributeRepository;
import ai.msg.training.portal.daoImpl.IntentRepository;
import ai.msg.training.portal.daoImpl.PromptRepository;
import ai.msg.training.portal.daoImpl.TopicRepository;
import ai.msg.training.portal.module.intent.beans.Attributes;
import ai.msg.training.portal.module.intent.beans.ConversationTopic;
import ai.msg.training.portal.module.intent.beans.IntentAttributes;
import ai.msg.training.portal.module.intent.beans.IntentDto;
import ai.msg.training.portal.module.intent.beans.Prompt;

@Service
public class IntentTrainerService {

	@Autowired
	TopicRepository topicDao;

	@Autowired
	IntentRepository intentDao;
	
	@Autowired
	PromptRepository promptDao;
	
	@Autowired
	AttributeRepository attributeDao;
	@Autowired
	AttributeAssociationRepository attributeAssociationDao;
	
	HttpRequestSataus status=new HttpRequestSataus();

	public HttpRequestSataus saveEntity(Object obj){
		try{
			String response="";
		if (obj instanceof ConversationTopic) {
			ConversationTopic dto = (ConversationTopic) obj;
			topicDao.save(dto);
			response= "Topic created successfully";
		}
		else if (obj instanceof IntentDto) {
			IntentDto dto = (IntentDto) obj;
			intentDao.save(dto);
			response= "Intent created successfully";
		}
		else if (obj instanceof Attributes) {
			Attributes dto = (Attributes) obj;
			attributeDao.save(dto);
			response= "Intent attribute created successfully";
		}
		else if (obj instanceof Prompt) {
			Prompt dto = (Prompt) obj;
			promptDao.save(dto);
			response= "Intent prompt created successfully";
		}
		else if (obj instanceof IntentAttributes) {
			IntentAttributes dto = (IntentAttributes) obj;
			attributeAssociationDao.save(dto);
			response= "attributed successfully associated with tenant intent";
		}
		status.setMessage(response);
		status.setStatusCode(200);
		}catch(Exception ex){
			status.setMessage(ex.getMessage());
			status.setStatusCode(999);
		}
		return status;
	}
	
	public List<Attributes> fetchAllAttributes(){
		
		return attributeDao.findAll(); 
	}
}
