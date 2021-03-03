package com.common.system.mapper;

import com.common.system.entity.TestFreemark;

public interface TestFreemarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestFreemark record);

    int insertSelective(TestFreemark record);

    TestFreemark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestFreemark record);

    int updateByPrimaryKey(TestFreemark record);
}