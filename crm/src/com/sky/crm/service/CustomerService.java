package com.sky.crm.service;

import com.sky.common.utils.Page;
import com.sky.crm.pojo.Customer;
import com.sky.crm.pojo.QueryVo;

public interface CustomerService {

	//ͨ���ĸ����� ��ѯ��ҳ����
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	//ͨ��ID��ѯ�ͻ�
	public Customer selectCustomerById(Integer id);
	
	//�޸Ŀͻ�ͨ��ID
	public void updateCustomerById(Customer customer);
	
	//ͨ��IDɾ���ͻ�
	public void deleteCustomerById(Integer id);
	
}
