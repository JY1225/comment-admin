package com.common.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.system.entity.Cust_jccjs_list;
import com.common.system.mapper.CustJccjsMapper;
import com.common.system.service.CustJccjsService;
import com.github.pagehelper.PageHelper;
@Service
public class CustJccjsImpl implements CustJccjsService {
	@Autowired
    private CustJccjsMapper custJccjsMapper;
	@Override
	public List<Cust_jccjs_list> listForPage(Integer pageNum, Integer pageSize, Integer userId) {
		if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
		return custJccjsMapper.listForPage(userId);
	}

}
