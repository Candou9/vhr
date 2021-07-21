package org.jx.vhr.mapper;

import org.jx.vhr.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    Menu queryById(Integer id);

    List<Menu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Menu> queryAll(Menu menu);

    int insert(Menu menu);

    int insertBatch(@Param("entities") List<Menu> entities);

    int insertOrUpdateBatch(@Param("entities") List<Menu> entities);

    int update(Menu menu);

    int deleteById(Integer id);

    List<Menu> getMenuByHrId(Integer hrid);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);
}

