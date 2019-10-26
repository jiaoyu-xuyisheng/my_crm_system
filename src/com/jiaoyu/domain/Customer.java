package com.jiaoyu.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Long cust_id;
	
	private String cust_name;
	private String cust_linkman;
	private String cust_phone;
	private String cust_mobile;

	
	//引用关联的数据字典对象
		private base_dict cust_source;
		private base_dict cust_industry;
		private base_dict cust_level;
		
	

		
		
		

	


	public base_dict getCust_source() {
			return cust_source;
		}
		public void setCust_source(base_dict cust_source) {
			this.cust_source = cust_source;
		}
		public base_dict getCust_industry() {
			return cust_industry;
		}
		public void setCust_industry(base_dict cust_industry) {
			this.cust_industry = cust_industry;
		}
		public base_dict getCust_level() {
			return cust_level;
		}
		public void setCust_level(base_dict cust_level) {
			this.cust_level = cust_level;
		}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
}
