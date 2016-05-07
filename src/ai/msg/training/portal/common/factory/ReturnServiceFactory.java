package ai.msg.training.portal.common.factory;

import ai.msg.training.portal.common.service.PortalService;
import ai.msg.training.portal.common.utils.PortalServiceName;
import ai.msg.training.portal.service.LoginService;
import ai.msg.training.portal.serviceImpl.LoginServiceImpl;

public class ReturnServiceFactory implements ServiceFactory{

	public static ReturnServiceFactory factory=null;
	
	public static ReturnServiceFactory getInstance(){
		if(factory==null){
			factory=new ReturnServiceFactory();
		}
		return factory;
	 }

	@Override
	public PortalService<?,?> getService(PortalServiceName service) {
		PortalService<?,?> msgService=null;
		
		switch(service){
		case LOGIN :
			msgService=(LoginService) new LoginServiceImpl();
		    break;
		
		}
		return msgService;
	}
}
