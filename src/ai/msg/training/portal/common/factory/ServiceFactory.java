package ai.msg.training.portal.common.factory;

import ai.msg.training.portal.common.service.PortalService;
import ai.msg.training.portal.common.utils.PortalServiceName;

public interface ServiceFactory {

	PortalService<?, ?> getService(PortalServiceName service);
	
}
