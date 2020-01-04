package com.common.system.service;

import com.common.system.entity.RcPrivilege;

import java.util.List;

/**
 * 
 */
public interface PrivilegeService {
    int add(RcPrivilege privilege);
    int delete(RcPrivilege privilege);
    int deleteByRoleId(Integer roleId);
    List<RcPrivilege> getByRoleId(Integer roleId);
}
