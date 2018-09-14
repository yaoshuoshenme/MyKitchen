package com.edu.mapper;

import com.edu.pojo.KeyWord;

public interface KeyWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeyWord record);

    int insertSelective(KeyWord record);

    KeyWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeyWord record);

    int updateByPrimaryKey(KeyWord record);
}