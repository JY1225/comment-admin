package com.common.system.service;

import com.common.system.entity.RcDir;
import com.github.pagehelper.PageInfo;

public interface DirService {

	PageInfo<RcDir> listForPage(Integer pageNum, Integer pageSize);

}
