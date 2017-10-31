package com.sf.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.DAOBase.IBaseDAO;

@Service("baseService")
public class BaseService<T> {
	
	@Resource(name="dao")
	public IBaseDAO<T> dao;
	
	public void save(T entity){
		dao.save(entity);
	}
	
	public void delete(Class<T> clazz,String[] ids){
		dao.delete(clazz,ids);
	}
	
	public void update(T entity){
		dao.update(entity);
	}
	
	public T find(Class<T> clazz,long id){
		T t = dao.find(clazz,id);
		return t;
	}
}
