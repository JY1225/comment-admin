package com.common.system.service;

import com.common.system.entity.RcRole;
import com.common.system.entity.RcRoleWrapper;
import com.common.system.util.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface RoleService {

    PageInfo<RcRole> listForPage(Integer pageNum, Integer pageSize);

    int deleteById(Integer id);

    Result<RcRole> selectById(Integer id);

    RcRole selectByRoleName(String roleName);

    RcRole selectByRoleValue(String roleValue);

    Result<Integer> save(RcRole role, List<Integer> permissionIds);
    Result<Integer> update(RcRole role);

    List<RcRoleWrapper> getRoleWrapperList();
}
