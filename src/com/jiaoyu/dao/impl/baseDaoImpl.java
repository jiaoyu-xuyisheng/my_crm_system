package com.jiaoyu.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.jiaoyu.dao.BaseDao;

@SuppressWarnings("all")
public class baseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;

	public baseDaoImpl() {
		//得到传入类型的父类！！
		ParameterizedType ptClass=(ParameterizedType)this.getClass().getGenericSuperclass();
		//得到当前的类型相当于一个类的class方法
		clazz=	(Class) ptClass.getActualTypeArguments()[0];
		
	}

	/**
	 * 保存对象！！
	 */
	@Override
	public void save(T t) {
		 getHibernateTemplate().save(t);
		
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);		
	}

	@Override
	public void delete(Serializable id) {
		T t=this.getById(id);//先取然后在删;
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}

	
	@Override
	public T getById(Serializable id) {
		return (T)getHibernateTemplate().get(clazz, id);
	}

	
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数，总记录数！！
		dc.setProjection(Projections.rowCount());
		List<Long> list=(List<Long>)getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if(list!=null&&list.size()>0) {
			Long count=list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		System.out.println(start+"haha"+pageSize);
		List<T> list=(List<T>) getHibernateTemplate().findByCriteria(dc,start,pageSize);
		System.out.println(list);
		return list;
	}

	@Override
	public List<T> getListByDc(DetachedCriteria dc) {
		List<T> list=(List<T>)getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);		
	}

}
