package cn.doublehh.system.service.impl;

import cn.doublehh.base.service.impl.BaseServiceImpl;
import cn.doublehh.system.dao.ResourceMapper;
import cn.doublehh.system.model.Resource;
import cn.doublehh.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author wangzy
 * @Date : 2017/8/11
 * @Description : 资源接口实现类
 */
@Service
@Transactional
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    //更新父级菜单信息
    private void updateParent(Resource resource) {
        Integer pid = resource.getPid();
        if (pid != null) {
            Resource parentResource = resourceMapper.selectByPrimaryKey(pid);
            parentResource.setLeaf("N");
            resourceMapper.updateByPrimaryKey(parentResource);
        }
    }

    public int save(Resource resource) {
        updateParent(resource);
        return resourceMapper.insert(resource);
    }

    public int update(Resource resource) {
        updateParent(resource);
        return resourceMapper.updateByPrimaryKey(resource);
    }


    public int delete(Object key) {
        Resource resource = resourceMapper.selectByPrimaryKey(key);
        int result = resourceMapper.deleteByPrimaryKey(key);
        Integer pid = resource.getPid();
        if (pid != null) {
            Example example = new Example(Resource.class);
            example.createCriteria().andEqualTo("pid", pid);
            int count = resourceMapper.selectCountByExample(example);
            Resource parentResource = resourceMapper.selectByPrimaryKey(pid);
            if (count > 0) {
                parentResource.setLeaf("N");
            } else {
                parentResource.setLeaf("Y");
            }
            resourceMapper.updateByPrimaryKey(parentResource);
        }
        return result;
    }

    @Override
    public List<Resource> listResources() {
        return resourceMapper.selectAll();
    }

    @Override
    public List<Resource> getResourcesByPidAndType(Resource resource) {
        return resourceMapper.getResourcesByPidAndType(resource);
    }

    @Override
    public List<Resource> getResourcesByRoleId(Integer roleId) {
        return resourceMapper.getResourcesByRoleId(roleId);
    }

    //通过userId获取菜单资源
    @Override
    public List<Resource> getResourcesByUserId(Integer userId, Integer type, Integer pid) {
        return resourceMapper.getResourcesByUserId(userId, type, pid);
    }
}
