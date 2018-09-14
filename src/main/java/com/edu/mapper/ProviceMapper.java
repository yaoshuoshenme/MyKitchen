package com.edu.mapper;

import com.edu.pojo.Provice;

public interface ProviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provice record);

    int insertSelective(Provice record);

    Provice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provice record);

    int updateByPrimaryKey(Provice record);
}