package com.jiaoyu.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.jiaoyu.dao.UserDao;
import com.jiaoyu.domain.Customer;
import com.jiaoyu.domain.my_user;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	
	//查找用户
	@Override
	public my_user getByUserCode(String userCode) {
		
		return getHibernateTemplate().execute(new HibernateCallback<my_user>() {

			@Override
			public my_user doInHibernate(Session session) throws HibernateException {
				String hql="from my_user where u_uname=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, userCode);
				my_user u = (my_user) query.uniqueResult();
				return u;
			}
		});
		
		
	}

	//保存用户
	@Override
	public void saveUser(my_user u) {
		getHibernateTemplate().save(u);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		
		List<Long> list=(List<Long>)getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if(list!=null&&list.size()>0) {
			Long count=list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}
	
	
	/**
	 * 修改用户
	 */
	@Override
	public void updateUser(my_user u) {
		getHibernateTemplate().update(u);
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<my_user> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		System.out.println(start+"haha"+pageSize);
		List<my_user> list=(List<my_user>) getHibernateTemplate().findByCriteria(dc,start,pageSize);
		System.out.println(list);
		return list;
	}

	@Override
	public my_user getUserById(Serializable id) {
		
	 my_user user =(my_user) getHibernateTemplate().get(my_user.class, id);
		return user;
	}
	
	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(Serializable id) {
		my_user user = getUserById(id);
		System.out.println(user.getU_uname()+"/"+user.getU_upassword());
		getHibernateTemplate().delete(user);
		
	}





}
