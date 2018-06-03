package cn.doublehh.system.service;

import cn.doublehh.base.service.BaseService;
import cn.doublehh.system.model.Role;
import cn.doublehh.system.model.RoleResource;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 角色资源Service
 */
public interface RoleResourceService extends BaseService<RoleResource> {

    void saveRoleResources(Role role);
}
