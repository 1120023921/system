package cn.doublehh.system.service.impl;

import cn.doublehh.base.service.ExampleBuilder;
import cn.doublehh.base.service.impl.BaseServiceImpl;
import cn.doublehh.system.dao.UserMapper;
import cn.doublehh.system.model.User;
import cn.doublehh.system.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 用户接口实现类
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    /* (non-Javadoc)
     * @see net.zjwu.mis.system.service.UserService#listUsers()
     */
    @Override
    public List<User> listUsers() {
        return userMapper.selectAll();
    }

    /* (non-Javadoc)
     * @see net.zjwu.mis.system.service.UserService#getUsersByRoleId(int)
     */
    @Override
    public List<User> getUsersByRoleId(int roleId) {
        return userMapper.getUsersByRoleId(roleId);
    }


    /* (non-Javadoc)
     * @see net.zjwu.mis.system.service.UserService#getUserByUid(java.lang.String)
     */
    @Override
    public User getUserByUid(String uid) {
        return userMapper.getUserByUid(uid);
    }


    /* (non-Javadoc)
     * @see net.zjwu.mis.system.service.UserService#listUsersPaged()
     */
    @Override
    public PageInfo<User> listUsersPaged(int page, int pageSize, User user) {
        ExampleBuilder example = new ExampleBuilder(user.getClass());
        example.andEqualTo(user);
        PageHelper.startPage(page, pageSize);
        List<User> users = userMapper.selectByExample(example);
        return new PageInfo<User>(users);
    }

    @Override
    public List<User> getSerach(String key) {
        return userMapper.getSerach(key);
    }
}
