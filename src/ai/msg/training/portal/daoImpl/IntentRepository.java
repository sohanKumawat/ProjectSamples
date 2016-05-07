package ai.msg.training.portal.daoImpl;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ai.msg.training.portal.module.intent.beans.IntentDto;

@Repository
@Transactional
public interface IntentRepository  extends CrudRepository<IntentDto, String>{

	
	
}
