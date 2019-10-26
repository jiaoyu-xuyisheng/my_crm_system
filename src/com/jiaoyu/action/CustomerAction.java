package com.jiaoyu.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.jiaoyu.domain.Customer;
import com.jiaoyu.domain.base_dict;
import com.jiaoyu.domain.pageBean;
import com.jiaoyu.service.customerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	//getparameter and new project;
	private Customer customer=new Customer();	
	private Integer page;
	private Integer rows;
	private customerService cs;

	
	private File photo;//上传的文件会自动封装到file的文件中;
	//文件名;
	private String photoFileName;
	//图片格式
	private String photoContentType;
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	

	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	
	
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	//this is a method for show customerList;客户列表;

	@SuppressWarnings("all")
	public String custList() throws Exception {	
		DetachedCriteria dc =DetachedCriteria.forClass(Customer.class);
		
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		pageBean  pb=cs.getPageBean(dc,page,rows);
		
		Map map= new HashMap();
		map.put("total", pb.getTotalCount());
		map.put("rows",pb.getList());
		System.out.println(pb.getList());
		Gson gson=new Gson();
		String json=gson.toJson(map);
		System.out.println(json);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	//保存客户！
	public String saveCustomer() throws Exception {
		if(photo!=null) {
			System.out.println("fileType:"+photoContentType);
			System.out.println("fileName:"+photoFileName);
			photo.renameTo(new File("D:/upload/"+photoFileName));
		}
			cs.saveCustomer(customer);
			System.out.println("success save customer!!!");
		return null;
	}
	
	//修改用户
	public String editShowCustomer() throws Exception{
		Customer c=cs.getById(customer.getCust_id());
		Gson gson =new Gson();
		String json = gson.toJson(c);
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	//reduce get and set Method;	
	public void setCs(customerService cs) {
		this.cs = cs;
	}

	@Override
	public Customer getModel() {
		return customer;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	
	

	

}
