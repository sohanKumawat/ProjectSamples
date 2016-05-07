package ai.msg.training.portal.daoImpl;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.msg.training.portal.module.intent.beans.Attributes;

@Repository
@Transactional
public interface AttributeRepository extends JpaRepository<Attributes, String>{

}
