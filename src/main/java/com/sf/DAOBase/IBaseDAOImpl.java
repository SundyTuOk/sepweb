package com.sf.DAOBase;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class IBaseDAOImpl<T> extends HibernateDaoSupport implements IBaseDAO<T> {

	private Logger logger = Logger.getLogger(IBaseDAOImpl.class);
	
	
	public void save(T entity) {
		try{
			this.getHibernateTemplate().save(entity);
		}catch(DataAccessException e){
			logger.error(e);
		}
		
		
	}

	public void delete(Class<T> clazz,String[] ids) {
		T entity=null;
		try {
			for (int i = 0; i < ids.length; i++) {
				entity=this.find(clazz,Long.parseLong(ids[i]));
				this.getHibernateTemplate().delete(entity);
			}
		} catch (HibernateException e) {
			logger.error(e.toString());
		}finally{
			entity=null;
		}
		
		
	}

	public void update(T entity) {
		try {
				this.getHibernateTemplate().update(entity);
			} catch (HibernateException sqle) {
				logger.error(sqle.toString());
			}
		
	}

	public T find(Class<T> clazz,long id) {
		T entity=null;
		try {
			entity=(T) this.getHibernateTemplate().get(clazz, id);
		} catch (HibernateException e) {
			entity=null;
			logger.error(e.toString());
		}
		return entity;
	}

	public void saveOrUpdate(T entity) {
		try {
				this.getHibernateTemplate().saveOrUpdate(entity);
			} catch (RuntimeException e) {
				throw e;
			}
		
	}

	public List<T> findAll(Class<T> t) {
		List<T> list=(List<T>)this.getHibernateTemplate().find("from "+t.getName());
		return list;
	}

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
