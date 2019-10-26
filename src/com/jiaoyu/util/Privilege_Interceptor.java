package com.jiaoyu.util;

import java.util.Map;

import com.jiaoyu.domain.my_user;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Privilege_Interceptor extends MethodFilterInterceptor {

	@Override
	//This is a bar cutter(栏截器) that verifies（验证） whether or not to log in 
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.得到session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2.获得登录标识;
		my_user user=(my_user) session.get("user");
		//3.判断是否存在
		if(user!=null) {
			return invocation.invoke();
		}else {
			return "tologin";
		}
		
	
	}

}
