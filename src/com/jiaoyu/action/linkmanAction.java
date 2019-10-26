package com.jiaoyu.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.jiaoyu.domain.cst_linkman;
import com.jiaoyu.domain.pageBean;
import com.jiaoyu.service.linkmanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class linkmanAction extends ActionSupport implements ModelDriven<cst_linkman>{
	private cst_linkman cst_linkman=new cst_linkman();
	private linkmanService ls;
	/**
	 * 分页参数！！
	 */
	private Integer currentPage;
	private Integer pageSize;
	
	
	
	
	
	

	public String showLink() throws Exception {
		cst_linkman linkman=ls.getLinkById(cst_linkman.getLkm_id());
		System.out.println(cst_linkman.getLkm_id()+"xuyisheng1");
		ActionContext.getContext().put("linkman", linkman);
		return "showlink";
	}
	
	public String addLink() throws Exception {
		ls.save(cst_linkman);
		return "addLinkman";
	}
	
	public String linklist() throws Exception {
		DetachedCriteria dc=DetachedCriteria.forClass(cst_linkman.class);
		if(StringUtils.isNotBlank(cst_linkman.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name","%"+cst_linkman.getLkm_name()+"%"));
		}
		pageBean pb=ls.getPageBean(dc,currentPage,pageSize);
		System.out.println("this is pageBean");
		System.out.println(pb);
		ActionContext.getContext().put("pageBean", pb);
		return "linklist";
	}


	public void setLs(linkmanService ls) {
		this.ls = ls;
	}

	@Override
	public cst_linkman getModel() {
		
		return cst_linkman;
	}



	public Integer getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
