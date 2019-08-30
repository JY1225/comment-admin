package com.common.system.service;

import com.common.system.entity.RcDir;
import com.common.system.util.Result;
import com.github.pagehelper.PageInfo;

public interface DirService {

	PageInfo<RcDir> listForPage(Integer pageNum, Integer pageSize);

	Result<Integer> isHasOpenDir();

	Result<Integer> save(RcDir rcDir);

	void deleteById(Integer id);

	void updateById(RcDir rcDir);

}
