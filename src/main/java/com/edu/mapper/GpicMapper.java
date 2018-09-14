package com.edu.mapper;

import com.edu.pojo.Gpic;

public interface GpicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gpic record);

    int insertSelective(Gpic record);

    Gpic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gpic record);

    int updateByPrimaryKey(Gpic record);
}