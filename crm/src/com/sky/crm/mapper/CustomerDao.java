package com.sky.crm.mapper;

import java.util.List;

import com.sky.crm.pojo.Customer;
import com.sky.crm.pojo.QueryVo;

public interface CustomerDao {

	//������
	public Integer customerCountByQueryVo(QueryVo vo);
	//�����
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//ͨ��ID��ѯ�ͻ�
	public Customer selectCustomerById(Integer id);
	
	//�޸Ŀͻ�ͨ��ID
	public void updateCustomerById(Customer customer);
	
	//ͨ��IDɾ���ͻ�
	public Customer deleteCustomerById(Integer id);
	
}
