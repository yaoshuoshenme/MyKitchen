package com.edu.mapper;

import com.edu.pojo.Repic;

public interface RepicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Repic record);

    int insertSelective(Repic record);

    Repic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Repic record);

    int updateByPrimaryKey(Repic record);
}