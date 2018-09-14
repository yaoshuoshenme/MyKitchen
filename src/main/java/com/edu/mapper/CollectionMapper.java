package com.edu.mapper;

import com.edu.pojo.Collection;

import java.util.List;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    List<Collection> selectByUid(Integer uid);

}