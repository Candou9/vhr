package org.jx.vhr.mapper;

import org.jx.vhr.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    Department queryById(Integer id);

    List<Department> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Department> queryAll(Department department);

    int insert(Department department);

    int insertBatch(@Param("entities") List<Department> entities);

    int insertOrUpdateBatch(@Param("entities") List<Department> entities);

    int update(Department department);

    int deleteById(Integer id);

    List<Department> getAllDepartmentByParentId(int i);
}

