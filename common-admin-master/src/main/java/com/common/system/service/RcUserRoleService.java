package com.common.system.service;

import com.common.system.entity.RcUserRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface RcUserRoleService extends IService<RcUserRole> {
	boolean deleteByUserId(Integer userId);
    List<RcUserRole> getByUserId(Integer userId);
}
