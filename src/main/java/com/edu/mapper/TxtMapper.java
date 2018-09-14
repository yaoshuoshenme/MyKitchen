package com.edu.mapper;

import com.edu.pojo.Txt;

public interface TxtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Txt record);

    int insertSelective(Txt record);

    Txt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Txt record);

    int updateByPrimaryKey(Txt record);
}