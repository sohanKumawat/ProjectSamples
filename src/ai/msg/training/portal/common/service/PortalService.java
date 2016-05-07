package ai.msg.training.portal.common.service;

import ai.msg.training.portal.dao.PortalDao;



public interface PortalService< T extends PortalDao<V>, V> {

	    boolean save(V v);
	    /*void setDao(T t);*/
	    V get(String id);
}
