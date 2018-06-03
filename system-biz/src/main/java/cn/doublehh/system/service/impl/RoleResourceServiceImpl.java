package cn.doublehh.system.service.impl;

import cn.doublehh.base.service.impl.BaseServiceImpl;
import cn.doublehh.system.dao.RoleResourceMapper;
import cn.doublehh.system.model.Resource;
import cn.doublehh.system.model.Role;
import cn.doublehh.system.model.RoleResource;
import cn.doublehh.system.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 角色资源接口实现类
 */
@Service
@Transactional
public class RoleResourceServiceImpl extends BaseServiceImpl<RoleResource> implements RoleResourceService {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public void saveRoleResources(Role role) {
        roleResourceMapper.deleteRoleResourcesByRoleId(role.getId());
        for (Resource resource : new HashSet<Resource>(role.getResources())) {
            RoleResource roleResource = new RoleResource();
            roleResource.setRoleId(role.getId());
            roleResource.setResourceId(resource.getId());
            roleResourceMapper.insert(roleResource);
        }
    }
}
