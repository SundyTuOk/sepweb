package com.sf.DAOBase;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IDAO {
	public void save(Object entity);
	public void delete(Object entity);
	public void update(Object entity);
	public void queryByCriteria(DetachedCriteria criteria);
	public <T,K> List<K> queryAll(Class<T> clazz);
}
