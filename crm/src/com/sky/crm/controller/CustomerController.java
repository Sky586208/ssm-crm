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
 * 客户管理
 * @author sky
 *
 */
@Controller
public class CustomerController {

	
	@Autowired
	private BaseDictService baseDictServcie;
	
	@Autowired
	private CustomerService customerService;
	
	//注解在成员变量上
	@Value("${FROM_TYPE}")
	private String FROM_TYPE;
	@Value("${INDUSTRY_TYPE}")
	private String INDUSTRY_TYPE;
	@Value("${LEVEL_TYPE}")
	private String LEVEL_TYPE;
	
	//入口
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model) {
		
		List<BaseDict> fromType = baseDictServcie.selectBaseDictListBycode(FROM_TYPE);
		List<BaseDict> industryType = baseDictServcie.selectBaseDictListBycode(INDUSTRY_TYPE);
		List<BaseDict> levelType = baseDictServcie.selectBaseDictListBycode(LEVEL_TYPE);
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过四个条件 查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//弹出修改页面
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id) {
		return  customerService.selectCustomerById(id);
	}
	
	//修改保存
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody
	String update(Customer customer) {
		//修改	
		customerService.updateCustomerById(customer);
		return "ok";
	}
	
	//弹出修改页面
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody
	String delete(Integer id) {
		//删除	
		customerService.deleteCustomerById(id);
		return "ok";
	}
	
}
