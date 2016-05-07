package ai.msg.training.portal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.msg.training.portal.common.beans.User;
import ai.msg.training.portal.common.beans.UserSessionBean;
import ai.msg.training.portal.dao.LoginDao;
import ai.msg.training.portal.daoImpl.LoginDaoImpl;
import ai.msg.training.portal.service.LoginService;

@Service("service")
public class LoginServiceImpl implements LoginService {

   
	@Autowired
	LoginDaoImpl loginDao;// =new LoginDaoImpl();
	
	@Autowired
	UserSessionBean UserSessionBean;

	
	@Override
	public boolean save(User v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User get(String Id) {
		UserSessionBean.setUser(this.loginDao.get(Id));
		System.out.println(""+UserSessionBean);
		return this.loginDao.get(Id);
	}

	
	public User validation(User v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User fetchUserInformation(User user) {
		
		return null;
	}

	@Override
	public boolean isValidationUser(User user) {
		System.out.println("*** loginDao *** "+this.loginDao);
		return this.loginDao.userValidation(user);
	}

	@Override
	public void setDao(LoginDao dao) {
	//	loginDao=dao;
		
	}
	
	public void setTenantDetails(int tenantId){
		this.UserSessionBean.setTenant((this.loginDao.getTenantDetails(tenantId)));
	//	return this.loginDao.getTenantDetails(tenantId);
		
	}
}
