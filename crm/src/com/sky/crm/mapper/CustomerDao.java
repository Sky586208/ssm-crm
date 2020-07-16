package com.sky.crm.mapper;

import java.util.List;

import com.sky.crm.pojo.Customer;
import com.sky.crm.pojo.QueryVo;

public interface CustomerDao {

	//总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	
	//修改客户通过ID
	public void updateCustomerById(Customer customer);
	
	//通过ID删除客户
	public Customer deleteCustomerById(Integer id);
	
}
