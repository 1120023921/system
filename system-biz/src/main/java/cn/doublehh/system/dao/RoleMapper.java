package cn.doublehh.system.dao;

import cn.doublehh.system.model.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    List<Role> getRolesByUserId(int userId);

    List<Role> getRolesByUid(String uid);
}