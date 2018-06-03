package cn.doublehh.system.service.impl;

import cn.doublehh.base.service.impl.BaseServiceImpl;
import cn.doublehh.system.dao.UserRoleMapper;
import cn.doublehh.system.model.Role;
import cn.doublehh.system.model.User;
import cn.doublehh.system.model.UserRole;
import cn.doublehh.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 用户角色接口实现类
 */
@Service
@Transactional
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void saveUserRoles(User user) {
        userRoleMapper.deleteUserRolesByUserId(user.getId());
        for(Role role:new HashSet<Role>(user.getRoles())){
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(role.getId());
            userRoleMapper.insert(userRole);
        }
    }

    @Override
    public void saveRoleUsers(Role role) {
        userRoleMapper.deleteRoleUsersByRoleId(role.getId());
        for (User user : new HashSet<User>(role.getUsers())) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(role.getId());
            userRoleMapper.insert(userRole);
        }
    }
}
