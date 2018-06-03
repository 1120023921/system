package cn.doublehh.system.dao;

import cn.doublehh.system.model.Resource;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResourceMapper extends Mapper<Resource> {

    List<Resource> getResourcesByPidAndType(Resource resource);

    List<Resource> getResourcesByRoleId(int roleId);

    List<Resource> getResourcesByUserId(@Param(value = "userId") Integer userId, @Param(value = "type") Integer type, @Param(value = "pid") Integer pid);
}