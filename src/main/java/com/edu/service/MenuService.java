package com.edu.service;

import com.edu.commons.vo.PageVo;
import com.edu.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {
    int insert(Menu record);

    Menu selectByMid(Integer id);

    PageVo<Menu> selectByPage(String title, Integer page,Integer limit, Integer flag);

    List<Menu> selectByUid(Integer uid, Integer flag);

    boolean updateByMid(Integer id,Integer flag);

    boolean updatecollect(Integer id);

    PageVo<Menu> selectByType(Integer tid, Integer page, Integer limit);
}
