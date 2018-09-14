package com.edu.mapper;

import com.edu.pojo.TxtPic;

public interface TxtPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TxtPic record);

    int insertSelective(TxtPic record);

    TxtPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TxtPic record);

    int updateByPrimaryKey(TxtPic record);
}