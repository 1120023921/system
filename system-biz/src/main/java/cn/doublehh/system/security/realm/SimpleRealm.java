package cn.doublehh.system.security.realm;

import cn.doublehh.system.dao.ResourceMapper;
import cn.doublehh.system.dao.RoleMapper;
import cn.doublehh.system.dao.UserMapper;
import cn.doublehh.system.model.Resource;
import cn.doublehh.system.model.Role;
import cn.doublehh.system.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description :
 */
public class SimpleRealm extends AuthorizingRealm {

	@Autowired
    private UserMapper userMapper;
	@Autowired
    private RoleMapper roleMapper;
	@Autowired
    private ResourceMapper resourceMapper;

    /**
     * 获取身份相关信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String uid = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        List<Role> roles = roleMapper.getRolesByUid(uid);
        for (Role role : roles) {
            // 基于Role的权限信息
            simpleAuthenticationInfo.addRole(role.getRoid());
            // 基于允许的权限信息
            List<Resource> resources = resourceMapper.getResourcesByRoleId(role.getId());
            for (Resource resource : resources) {
                if (!StringUtils.isEmpty(resource.getValue()))
                    simpleAuthenticationInfo.addStringPermission(resource.getValue());
            }
        }
        return simpleAuthenticationInfo;
    }

    /**
     * 获取身份验证相关信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String uid = (String) authenticationToken.getPrincipal();
        User user = userMapper.getUserByUid(uid);
        if (user == null) {
            throw new UnknownAccountException();
        }
        if (Boolean.FALSE.equals(user.getEnabled())) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUid(), user.getPassword(), getName());
        return authenticationInfo;
    }

//    public void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
//
//    public void setRoleMapper(RoleMapper roleMapper) {
//        this.roleMapper = roleMapper;
//    }
//
//    public void setResourceMapper(ResourceMapper resourceMapper) {
//        this.resourceMapper = resourceMapper;
//    }
}
