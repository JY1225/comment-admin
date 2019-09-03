package com.common.system.service;

import java.util.List;

import com.common.system.entity.Cust_jccjs_list;

public interface CustJccjsService {
	List<Cust_jccjs_list> listForPage(Integer pageNum, Integer pageSize,Integer userId);
}
