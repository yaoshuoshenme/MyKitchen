package com.edu.service;

import java.util.List;

public interface HistoryService {
    boolean deleteByMid(Integer mid);

    boolean deleteByUid(Integer uid);

    boolean insert(com.edu.pojo.History record);

    List<com.edu.pojo.History> selectByUid(Integer uid);

    boolean updateByMid(Integer mid);
}
