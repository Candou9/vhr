package org.jx.vhr.mapper;

import org.jx.vhr.model.MenuRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuRoleMapper {
    MenuRole queryById(Integer id);

    List<MenuRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<MenuRole> queryAll(MenuRole menuRole);

    int insert(MenuRole menuRole);

    int insertBatch(@Param("entities") List<MenuRole> entities);

    int insertOrUpdateBatch(@Param("entities") List<MenuRole> entities);

    int update(MenuRole menuRole);

    void deleteById(Integer id);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}

