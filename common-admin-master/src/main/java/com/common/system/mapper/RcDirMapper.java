package com.common.system.mapper;

import java.util.List;

import com.common.system.entity.RcDir;

public interface RcDirMapper {

	    RcDir selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(RcDir record);

	    List<RcDir> getRcDirList();

		List<RcDir> isHasOpenDir();

		void insert(RcDir rcDir);

		void deleteById(Integer id);

		void updateById(RcDir rcDir);
}
