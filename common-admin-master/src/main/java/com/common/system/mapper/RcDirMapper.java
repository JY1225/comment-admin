package com.common.system.mapper;

import java.util.List;

import com.common.system.entity.RcDir;

public interface RcDirMapper {

	    RcDir selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(RcDir record);

	    List<RcDir> getRcDirList();
}
