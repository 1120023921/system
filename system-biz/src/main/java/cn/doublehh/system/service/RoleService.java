package cn.doublehh.system.service;

import cn.doublehh.base.service.BaseService;
import cn.doublehh.system.model.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 角色接口
 */
public interface RoleService extends BaseService<Role> {

    List<Role> listRoles(Role role);

    PageInfo<Role> listRolesPaged(int page, int pageSize, Role role);

    List<Role> getRolesByUserId(int userId);

}
