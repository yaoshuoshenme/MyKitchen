package com.edu.service.impl;

import com.edu.mapper.HistoryMapper;
import com.edu.pojo.History;
import com.edu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper mapper;

    //删除指定记录
    @Override
    public boolean deleteByMid(Integer mid) {
        return mapper.deleteByMid(mid) > 0;
    }

    //删除全部记录
    @Override
    public boolean deleteByUid(Integer uid) {
        return mapper.deleteByUid(uid) > 0;
    }

    //新增记录
    @Override
    public boolean insert(History record) {
        return mapper.insert(record) > 0;
    }

    //查询全部记录
    @Override
    public List<History> selectByUid(Integer uid) {
        return mapper.selectByUid(uid);
    }

    //更新记录时间
    @Override
    public boolean updateByMid(Integer mid) {
        return mapper.updateByMid(mid) > 0;
    }
}
