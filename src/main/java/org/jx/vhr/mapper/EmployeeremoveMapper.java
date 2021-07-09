package org.jx.vhr.mapper;

import org.jx.vhr.model.Employeeremove;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Employeeremove)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 13:00:53
 */
public interface EmployeeremoveMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employeeremove queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employeeremove> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeeremove 实例对象
     * @return 对象列表
     */
    List<Employeeremove> queryAll(Employeeremove employeeremove);

    /**
     * 新增数据
     *
     * @param employeeremove 实例对象
     * @return 影响行数
     */
    int insert(Employeeremove employeeremove);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employeeremove> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Employeeremove> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employeeremove> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Employeeremove> entities);

    /**
     * 修改数据
     *
     * @param employeeremove 实例对象
     * @return 影响行数
     */
    int update(Employeeremove employeeremove);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

