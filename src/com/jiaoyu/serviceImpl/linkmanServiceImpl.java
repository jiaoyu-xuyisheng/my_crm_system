package com.jiaoyu.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.dao.linkmanDao;
import com.jiaoyu.domain.cst_linkman;
import com.jiaoyu.domain.pageBean;
import com.jiaoyu.service.linkmanService;

public class linkmanServiceImpl implements linkmanService {
	private linkmanDao ld;



	@Override
	public void save(cst_linkman linkman) {
	
		ld.saveOrUpdate(linkman);
	}

	public void setLd(linkmanDao ld) {
		this.ld = ld;
	}

	@Override
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount=ld.getTotalCount(dc);
		pageBean pagebean=new pageBean(currentPage, pageSize, totalCount);
		List<cst_linkman> linkman=ld.getPageList(dc, pagebean.getStart(),pagebean.getPageSize());
		pagebean.setList(linkman);
		return pagebean;
	}

	@Override
	public cst_linkman getLinkById(Long cust_id) {
		return ld.getById(cust_id);
	}


}
