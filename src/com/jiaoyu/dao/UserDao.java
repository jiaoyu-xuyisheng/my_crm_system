package com.jiaoyu.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.domain.Customer;
import com.jiaoyu.domain.my_user;

public interface UserDao {
	
	my_user getByUserCode(String userCode);

	void saveUser(my_user u);

	Integer getTotalCount(DetachedCriteria dc);

	List<my_user> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);
	
	void updateUser(my_user u);
	 
	
	my_user getUserById(Serializable id);
	
	void deleteUser(Serializable id);
}
