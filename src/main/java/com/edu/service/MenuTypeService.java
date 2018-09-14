package com.edu.service;

import com.edu.pojo.MenuType;

import java.util.List;

public interface MenuTypeService {
    boolean insert(MenuType record);


    MenuType selectById(Integer id);

    List<MenuType> selectAllParent();

    List<MenuType> selectAllByParentId(Integer id);
}
