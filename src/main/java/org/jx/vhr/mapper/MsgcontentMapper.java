package org.jx.vhr.mapper;

import org.jx.vhr.entity.Msgcontent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Msgcontent)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 13:00:59
 */
public interface MsgcontentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Msgcontent queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Msgcontent> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param msgcontent 实例对象
     * @return 对象列表
     */
    List<Msgcontent> queryAll(Msgcontent msgcontent);

    /**
     * 新增数据
     *
     * @param msgcontent 实例对象
     * @return 影响行数
     */
    int insert(Msgcontent msgcontent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Msgcontent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Msgcontent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Msgcontent> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Msgcontent> entities);

    /**
     * 修改数据
     *
     * @param msgcontent 实例对象
     * @return 影响行数
     */
    int update(Msgcontent msgcontent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

