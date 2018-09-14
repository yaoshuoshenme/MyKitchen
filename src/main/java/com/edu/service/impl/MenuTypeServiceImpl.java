package com.edu.service.impl;

import com.edu.mapper.MenuTypeMapper;
import com.edu.pojo.MenuType;
import com.edu.service.MenuTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuTypeServiceImpl implements MenuTypeService {
    @Autowired
    private MenuTypeMapper mapper;

    //添加分类
    @Override
    public boolean insert(MenuType record) {
        return mapper.insert(record) > 0;
    }

    //分类详情
    @Override
    public MenuType selectById(Integer id) {
        return mapper.selectById(id);
    }
    //查询一级分类
    @Override
    public List<MenuType> selectAllParent() {
        return mapper.selectAllParent();
    }

    //查询子类
    @Override
    public List<MenuType> selectAllByParentId(Integer id) {
        return mapper.selectAllByParentId(id);
    }
}
