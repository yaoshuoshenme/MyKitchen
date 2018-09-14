package com.edu.mapper;

import com.edu.pojo.History;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryMapper {
    int deleteByMid(Integer mid);

    int deleteByUid(Integer uid);

    int insert(History record);

    List<History> selectByUid(Integer uid);

    int updateByMid(Integer mid);

}