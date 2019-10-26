package com.jiaoyu.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.google.gson.Gson;
import com.jiaoyu.domain.base_dict;
import com.jiaoyu.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseDictAction extends ActionSupport{

	private String dict_type_code;
	private BaseDictService bds;
	

	public String getBaseDictList() throws Exception {
		DetachedCriteria dc=DetachedCriteria.forClass(base_dict.class);
		if(StringUtils.isNotBlank(dict_type_code)) {
			dc.add(Restrictions.eq("dict_type_code",dict_type_code));
	
		}
		List<base_dict> baseDictList=	bds.getBaseDictList(dc);
		Gson gson=new Gson();
		String jsonbaseDictList=gson.toJson(baseDictList);
		System.out.println(jsonbaseDictList);
		ServletActionContext.getResponse().setContentType("application/json; charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonbaseDictList);
		return null;
	}
	
	
	//get and set method;
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBds(BaseDictService bds) {
		this.bds = bds;
	}

	
	
}
