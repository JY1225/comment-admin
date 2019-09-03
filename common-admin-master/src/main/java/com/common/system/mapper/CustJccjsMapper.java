package com.common.system.mapper;

import java.util.List;

import com.common.system.entity.Cust_jccjs_list;

public interface CustJccjsMapper {
	List<Cust_jccjs_list> listForPage(Integer pageNum);
}
