package ai.msg.training.portal.service;

import ai.msg.training.portal.common.beans.User;
import ai.msg.training.portal.common.service.PortalService;
import ai.msg.training.portal.dao.LoginDao;

public interface LoginService extends PortalService<LoginDao, User>{
	
	boolean isValidationUser(User user);
	User fetchUserInformation(User user);
	public void setDao(LoginDao dao);
	
}
