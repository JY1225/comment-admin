package com.common.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.system.entity.RcDir;
import com.common.system.mapper.RcDirMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class DirServiceImpl implements com.common.system.service.DirService {
	@Autowired
    private RcDirMapper dirMapper;
	@Override
	public PageInfo<RcDir> listForPage(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<RcDir> dirList = dirMapper.getRcDirList();
       
        return new PageInfo<>(dirList);
	}

}
