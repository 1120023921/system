package cn.doublehh.system.service.impl;

import cn.doublehh.base.service.ExampleBuilder;
import cn.doublehh.base.service.impl.BaseServiceImpl;
import cn.doublehh.system.dao.RoleMapper;
import cn.doublehh.system.dao.UserMapper;
import cn.doublehh.system.dao.UserRoleMapper;
import cn.doublehh.system.model.Role;
import cn.doublehh.system.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 角色接口实现类
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> listRoles(Role role) {
        ExampleBuilder example = new ExampleBuilder(role.getClass());
        example.andEqualTo(role);
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<Role> getRolesByUserId(int userId) {
        return roleMapper.getRolesByUserId(userId);
    }

    @Override
    public PageInfo<Role> listRolesPaged(int page, int pageSize, Role role) {
        ExampleBuilder example = new ExampleBuilder(role.getClass());
        example.andEqualTo(role);
        PageHelper.startPage(page, pageSize);
        List<Role> roles = roleMapper.selectByExample(example);
        return new PageInfo<Role>(roles);
    }
}
