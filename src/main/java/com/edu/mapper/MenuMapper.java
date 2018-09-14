package com.edu.mapper;

import com.edu.commons.vo.PageVo;
import com.edu.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuMapper {

    int insert(Menu record);

    Menu selectByMid(Integer id);

    PageVo<Menu> selectByPage(@Param("title") String title, @Param("page") Integer page, @Param("limit") Integer limit, @Param("flag")Integer flag);

    List<Menu> selectByUid(Integer uid, Integer flag);

    int updateByMid(Integer id,Integer flag);

    int updatecollect(Integer id);

    PageVo<Menu> selectByType(@Param("tid") Integer tid, @Param("page") Integer page, @Param("limit") Integer limit);

}