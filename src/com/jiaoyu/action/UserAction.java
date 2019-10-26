package com.jiaoyu.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.jiaoyu.domain.my_user;
import com.jiaoyu.domain.pageBean;
import com.jiaoyu.service.UserService;
import com.jiaoyu.serviceImpl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<my_user> {
	private UserService us;
	private my_user u=new my_user();
	
	private Integer page; //页码，起始值 1。
	private Integer rows; //每页显示行。

	public void setUs(UserService us) {
		this.us = us;
	}	
	
	//用户登录！！
	public String login() throws Exception {
		my_user use = us.getUserByCodePassword(u);
		ActionContext.getContext().getSession().put("user", use);
		return "login";
	}
	
	//添加用户！！！
	public String usersave() throws Exception {
		us.saveDao(u);

		return null;
	}
	

	//修改用户！！！
	public String userupdate() throws Exception {
		us.updateDao(u);
		return null;
	}
	
	//删除用户！！！
	public String userdelete() throws Exception {
		us.deleteUserById(u.getU_uid());
		return null;
	}
	
	//得到用户列表！！
	@SuppressWarnings("unchecked")
	public String userlist() throws Exception {
		DetachedCriteria dc=DetachedCriteria.forClass(my_user.class);
		if(StringUtils.isNotBlank(u.getU_uname())) {
			dc.add(Restrictions.like("u_uname", "%"+u.getU_uname()+"%"));
		}
		pageBean  pb=us.getPageBean(dc,page,rows);
		
		Map map=new HashMap();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		Gson gson=new Gson();
		String json = gson.toJson(map);
		System.out.println(json);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	@Override
	public my_user getModel() {
		
		return u;
	}
	
}
