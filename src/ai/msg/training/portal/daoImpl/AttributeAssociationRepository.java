package ai.msg.training.portal.daoImpl;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ai.msg.training.portal.module.intent.beans.IntentAttributes;

@Repository
@Transactional
public interface AttributeAssociationRepository extends CrudRepository<IntentAttributes, String>  {

}
