package cn.doublehh.system.dao;

import cn.doublehh.system.model.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    User getUserByUid(@Param(value = "uid") String uid);

    User getUserWithRolesByUid(String uid);

    List<User> getUsersByRoleId(int roleId);

    List<User> getSerach(@Param(value = "key") String key);
}