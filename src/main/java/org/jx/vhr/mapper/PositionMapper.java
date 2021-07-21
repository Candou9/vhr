package org.jx.vhr.mapper;

import org.jx.vhr.model.Position;
import org.apache.ibatis.annotations.Param;
import org.jx.vhr.model.RespBean;

import java.util.List;

/**
 * (Position)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 13:01:01
 */
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPositions();

    Integer deletePositionsByIds(@Param("ids") Integer[] ids);
}

