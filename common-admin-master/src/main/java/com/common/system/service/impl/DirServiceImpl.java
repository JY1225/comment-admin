package com.common.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.system.entity.RcDir;
import com.common.system.mapper.RcDirMapper;
import com.common.system.util.Result;
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
	@Override
	public Result<Integer> isHasOpenDir() {
		Result<Integer> result=new Result<>();
		result.setStatus(true);
		List<RcDir> list = dirMapper.isHasOpenDir();
		if(list.size() > 0) {
			result.setMsg("已有开启目录，新目录状态不能为开启");
			result.setStatus(false);
		}		
		return result;
	}
	@Override
	public Result<Integer> save(RcDir rcDir) {
		Result<Integer> result=new Result<>();
		result.setStatus(true);
		try {
			dirMapper.insert(rcDir);
		}catch(Exception e) {
			result.setStatus(false);
		}
		return result;
	}
	
	@Override
	public void deleteById(Integer id){
		dirMapper.deleteById(id);
	}
	@Override
	public void updateById(RcDir rcDir) {
		dirMapper.updateById(rcDir);
		
	}
}
