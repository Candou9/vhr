package org.jx.vhr.mapper;

import org.jx.vhr.model.JobLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobLevelMapper {

    JobLevel queryById(Integer id);

    List<JobLevel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<JobLevel> queryAll(JobLevel joblevel);

    int insert(JobLevel joblevel);

    int insertBatch(@Param("entities") List<JobLevel> entities);

    int insertOrUpdateBatch(@Param("entities") List<JobLevel> entities);

    int update(JobLevel joblevel);

    int deleteById(Integer id);

    List<JobLevel> getAllJobLevels();

    Integer deleteJobLevelByIds(Integer[] ids);
}

