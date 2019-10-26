package com.jiaoyu.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.domain.Customer;
import com.jiaoyu.domain.base_dict;
import com.jiaoyu.domain.pageBean;

public interface customerService {
	//customer listPage Method;
	pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void saveCustomer(Customer customer);

	Customer getById(Long cust_id);
}
