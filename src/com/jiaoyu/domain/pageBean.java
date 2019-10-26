package com.jiaoyu.domain;

import java.util.List;

public class pageBean {
	//当前页数，
	private Integer currentPage;
	//每页显示条数
	private Integer pageSize;
	//总条数
	private Integer totalCount;
	
	//总页数
	private Integer totalPage;
	//客户列表
	private List list;
	
	
	public pageBean() {
		super();
	}
	
	public pageBean(Integer currentPage, Integer pageSize, Integer totalCount) {
		
		
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		if(this.currentPage==null) {
			this.currentPage=1;
		}
		if(this.currentPage<1) {
			this.currentPage=1;
		}
		if(this.pageSize==null) {
			this.pageSize=3;
		}
		this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;
		if(this.currentPage>this.totalPage) {
			this.currentPage=this.totalPage;
		}
	}
	
	public Integer getStart() {
		return (this.currentPage-1)*this.pageSize;
	}
	//get and set method;
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

}
