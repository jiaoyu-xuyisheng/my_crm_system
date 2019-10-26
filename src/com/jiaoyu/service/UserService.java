package com.jiaoyu.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.dao.UserDao;
import com.jiaoyu.domain.Customer;
import com.jiaoyu.domain.my_user;
import com.jiaoyu.domain.pageBean;
import com.jiaoyu.serviceImpl.UserServiceImpl;

public class UserService implements UserServiceImpl {
	private UserDao ud;

	public UserService() {
		System.out.println("hello");
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	/**
	 * 修改用户！！
	 */
	@Override
	public void updateDao(my_user u) {
		ud.updateUser(u);	
	}
	
	/**
	 * 登录
	 */
	@Override
	public my_user getUserByCodePassword(my_user u) {
		my_user user = ud.getByUserCode(u.getU_uname());
		if(user==null) {
			
			throw new RuntimeException("用户名错误！");
		}
		if(!user.getU_upassword().equals(u.getU_upassword())) {
		
			throw new RuntimeException("密码错误！");
		}
		return user;
	}
	/**
	 * 添加用户
	 */
	@Override
	public void saveDao(my_user u) {
		ud.saveUser(u);
		
	}

	/**
	 * 得到用户列表，带分页！！
	 * @param dc
	 * @param page
	 * @param rows
	 * @return
	 */
	public pageBean getPageBean(DetachedCriteria dc, Integer page, Integer rows) {
		Integer totalCount=ud.getTotalCount(dc);
		//create this Object is for totalPage have value and we can use pageBean's method;
		pageBean pb=new pageBean(page, rows,totalCount);
		List<my_user> list=ud.getPageList(dc,pb.getStart(),pb.getPageSize());
		//将list放入pageBean里。
		pb.setList(list);

		return pb;
		
	}
	
	/**
	 * 通过id得到用户;
	 */
	@Override
	public my_user getUserById(Serializable id) {
		
		return ud.getUserById(id);
	}

	/**
	 * 通过删除用户用户;
	 */
	@Override
	public void deleteUserById(Serializable id) {
		ud.deleteUser(id);
	}





}
