package cn.doublehh.system.service;

import cn.doublehh.base.service.BaseService;
import cn.doublehh.system.model.Resource;

import java.util.List;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 资源Service
 */
public interface ResourceService extends BaseService<Resource> {

    List<Resource> listResources();

    List<Resource> getResourcesByPidAndType(Resource resource);

    List<Resource> getResourcesByRoleId(Integer roleId);

    //通过userId获取userId所对应的角色资源
    List<Resource> getResourcesByUserId(Integer userId, Integer type, Integer pid);
}
