package cn.doublehh.system.service;

import cn.doublehh.base.service.BaseService;
import cn.doublehh.system.model.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 用户Service
 */
public interface UserService extends BaseService<User> {

    List<User> listUsers();

    PageInfo<User> listUsersPaged(int page, int pageSize, User user);

    List<User> getUsersByRoleId(int roleId);

    User getUserByUid(String uid);

    List<User> getSerach(@Param(value = "key") String key);

}
