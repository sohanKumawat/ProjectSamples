package ai.msg.training.portal.dao;

import ai.msg.training.portal.common.beans.User;

public interface LoginDao extends PortalDao<User>{

	boolean userValidation(User bean);
	
}
