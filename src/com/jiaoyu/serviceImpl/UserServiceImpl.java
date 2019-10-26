package com.jiaoyu.serviceImpl;

import java.io.Serializable;

import com.jiaoyu.domain.my_user;

public interface UserServiceImpl {
	my_user getUserByCodePassword(my_user u);
	void saveDao(my_user u);
	void updateDao(my_user u);
	my_user getUserById(Serializable id);
	void deleteUserById(Serializable id);
}
