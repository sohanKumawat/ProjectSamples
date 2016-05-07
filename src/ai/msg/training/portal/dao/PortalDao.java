package ai.msg.training.portal.dao;

public interface PortalDao<T> {

	boolean save(T t);
    T get(String Id);
    T validation(T t);
    //void setDao(T t);
}
