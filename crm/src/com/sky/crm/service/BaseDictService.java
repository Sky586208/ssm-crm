package com.sky.crm.service;

import java.util.List;

import com.sky.crm.pojo.BaseDict;

public interface BaseDictService {

	public List<BaseDict> selectBaseDictListBycode(String code);
	
}
