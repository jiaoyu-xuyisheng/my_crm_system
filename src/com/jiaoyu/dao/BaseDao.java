package com.jiaoyu.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.domain.Customer;

/**
 * 设置一个baseDao接口来设置增删改查方法
 * @author xuyisheng
 *
 * @param <T>
 */
public interface BaseDao<T> {
	void saveOrUpdate(T t);
	//增加
	void save(T t);
	//删除
	void delete(T t);
	//删除根据id删除对象；
	void delete(Serializable id);
	//改
	void update(T t);
	//查根据id查对象！！
	T getById(Serializable id);
	//查符合记录的总条数
	Integer getTotalCount(DetachedCriteria dc);
	//查分页
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	List<T> getListByDc(DetachedCriteria dc);
	
}
