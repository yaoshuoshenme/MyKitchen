package com.edu.mapper;

import com.edu.pojo.Mpic;

public interface MpicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mpic record);

    int insertSelective(Mpic record);

    Mpic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mpic record);

    int updateByPrimaryKey(Mpic record);
}