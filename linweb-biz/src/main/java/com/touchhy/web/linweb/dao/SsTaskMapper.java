package com.touchhy.web.linweb.dao;

import com.touchhy.web.linweb.entity.SsTask;
import com.touchhy.web.linweb.entity.SsTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface SsTaskMapper {
    int countByExample(SsTaskExample example);

    int deleteByExample(SsTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SsTask record);

    int insertSelective(SsTask record);

    List<SsTask> selectByExample(SsTaskExample example);

    SsTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SsTask record, @Param("example") SsTaskExample example);

    int updateByExample(@Param("record") SsTask record, @Param("example") SsTaskExample example);

    int updateByPrimaryKeySelective(SsTask record);

    int updateByPrimaryKey(SsTask record);
}