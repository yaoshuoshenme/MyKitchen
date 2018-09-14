package com.edu.mapper;

import com.edu.pojo.MenuType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuTypeMapper {

    int insert(MenuType record);


    MenuType selectById(Integer id);

    List<MenuType> selectAllParent();

    List<MenuType> selectAllByParentId(Integer id);


}