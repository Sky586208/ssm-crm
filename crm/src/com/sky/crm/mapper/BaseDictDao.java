package com.sky.crm.mapper;

import java.util.List;

import com.sky.crm.pojo.BaseDict;

public interface BaseDictDao {

	//��ѯ
	public List<BaseDict> selectBaseDictListByCode(String code);
	
}
