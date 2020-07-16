package com.sky.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.common.utils.Page;
import com.sky.crm.pojo.BaseDict;
import com.sky.crm.pojo.Customer;
import com.sky.crm.pojo.QueryVo;
import com.sky.crm.service.BaseDictService;
import com.sky.crm.service.CustomerService;

/**
 * �ͻ�����
 * @author sky
 *
 */
@Controller
public class CustomerController {

	
	@Autowired
	private BaseDictService baseDictServcie;
	
	@Autowired
	private CustomerService customerService;
	
	//ע���ڳ�Ա������
	@Value("${FROM_TYPE}")
	private String FROM_TYPE;
	@Value("${INDUSTRY_TYPE}")
	private String INDUSTRY_TYPE;
	@Value("${LEVEL_TYPE}")
	private String LEVEL_TYPE;
	
	//���
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model) {
		
		List<BaseDict> fromType = baseDictServcie.selectBaseDictListBycode(FROM_TYPE);
		List<BaseDict> industryType = baseDictServcie.selectBaseDictListBycode(INDUSTRY_TYPE);
		List<BaseDict> levelType = baseDictServcie.selectBaseDictListBycode(LEVEL_TYPE);
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//ͨ���ĸ����� ��ѯ��ҳ����
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//�����޸�ҳ��
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id) {
		return  customerService.selectCustomerById(id);
	}
	
	//�޸ı���
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody
	String update(Customer customer) {
		//�޸�	
		customerService.updateCustomerById(customer);
		return "ok";
	}
	
	//�����޸�ҳ��
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody
	String delete(Integer id) {
		//ɾ��	
		customerService.deleteCustomerById(id);
		return "ok";
	}
	
}
