package com.jiaoyu.serviceImpl;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import com.jiaoyu.dao.customerDao;
import com.jiaoyu.domain.Customer;
import com.jiaoyu.domain.pageBean;
import com.jiaoyu.service.customerService;


public class customerServiceImpl implements customerService {
		private customerDao cd;
		//this is a method for to make pageBean;
	/**
	 * 	//当前页数，
	 *		private Integer currentPage;这个前台传过来的
	 *	//每页显示条数
	 *	private Integer pageSize;这个前台传过来的
	 *	//总条数
	 *	private Integer totalCount;	这个通过dao到数据库查的;
	 *	//总页数
	 *	private Integer totalPage;这上是根据总条数来算的；已经算好了
	 *	//客户列表
	 *	private List list;//通过dao查的;
	 */
	@Override
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount=cd.getTotalCount(dc);
		//create this Object is for totalPage have value and we can use pageBean's method;
		pageBean pb=new pageBean(currentPage, pageSize,totalCount);
		List<Customer> list=cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//将list放入pageBean里。
		pb.setList(list);

		return pb;
	}


	public void setCd(customerDao cd) {
		this.cd = cd;
	}


	@Override
	public void saveCustomer(Customer customer) {		
		cd.saveOrUpdate(customer);
	}


	@Override
	public Customer getById(Long cust_id) {
		// TODO Auto-generated method stub
		return cd.getById(cust_id);
	}





	

}
