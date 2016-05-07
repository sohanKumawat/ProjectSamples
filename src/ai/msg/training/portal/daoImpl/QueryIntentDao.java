package ai.msg.training.portal.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ai.msg.training.portal.module.intent.beans.ConversationTopic;
import ai.msg.training.portal.module.intent.beans.IntentBean;

/**
*
* @author Sohan Kumawat
*/
@Repository
@Transactional()
public interface QueryIntentDao extends CrudRepository<IntentBean, String> {//JpaRepository ormongoRepository extends CurdRepository interface

	/*@Autowired
	JdbcTemplate jdbcTemplate;*/
	
    @Query("select a from IntentBean a inner join a.intentAttribute b where a.intentName=?1 and  a.intentName=b.intentName")
	public IntentBean findAllWithDescriptionQuery(String intentName);
	public List<IntentBean> findByIntentName(String intentName);
    public List<IntentBean> findAll();

    @Query("update IntentChildExpression set expressionText=?1 where id=?2 and intentName=?3")
    public int updateByIntentName(String expressionText,int id,String intentName);

    
}

