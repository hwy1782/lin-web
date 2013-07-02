package com.touchhy.web.linweb.dao;

import com.touchhy.web.linweb.entity.SsUser;
import com.touchhy.web.linweb.entity.SsUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface SsUserMapper {
    int countByExample(SsUserExample example);

    int deleteByExample(SsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SsUser record);

    int insertSelective(SsUser record);

    List<SsUser> selectByExample(SsUserExample example);

    SsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SsUser record, @Param("example") SsUserExample example);

    int updateByExample(@Param("record") SsUser record, @Param("example") SsUserExample example);

    int updateByPrimaryKeySelective(SsUser record);

    int updateByPrimaryKey(SsUser record);
}