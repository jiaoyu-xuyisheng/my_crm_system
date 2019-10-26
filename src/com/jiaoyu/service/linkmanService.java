package com.jiaoyu.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.domain.cst_linkman;
import com.jiaoyu.domain.pageBean;

public interface linkmanService {

	void save(cst_linkman linkman);

	pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	cst_linkman getLinkById(Long cust_id);



}
