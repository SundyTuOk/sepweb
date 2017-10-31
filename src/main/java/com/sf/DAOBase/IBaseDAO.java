package com.sf.DAOBase;

public interface IBaseDAO<T> {
	/**
	 * 储存一个实体到数据库
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 根据ID(主键)删除一条记录
	 * @param ids
	 */
	public void delete(Class<T> clazz,String[] ids);
	
	/**
	 * 更新记录
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public T find(Class<T> clazz,long id);
	
}
