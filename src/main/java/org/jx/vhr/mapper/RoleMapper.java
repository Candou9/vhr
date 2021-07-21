package org.jx.vhr.mapper;

import org.jx.vhr.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    Role queryById(Integer id);

    List<Role> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Role> queryAll(Role role);

    int insert(Role role);

    int insertBatch(@Param("entities") List<Role> entities);

    int insertOrUpdateBatch(@Param("entities") List<Role> entities);

    int update(Role role);

    int deleteById(Integer id);

    List<Role> getAllRoles();
}

