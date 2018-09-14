package com.edu.service.impl;

import com.edu.commons.vo.PageVo;
import com.edu.mapper.MenuMapper;
import com.edu.pojo.Menu;
import com.edu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper mapper;

    //新增菜谱
    @Override
    public int insert(Menu record) {
        return mapper.insert(record) ;
    }
    //通过mid查询菜谱
    @Override
    public Menu selectByMid(Integer id) {
        return mapper.selectByMid(id);
    }

    //分页模糊查询菜谱
    @Override
    public PageVo<Menu> selectByPage(String title, Integer page, Integer limit, Integer flag) {

        Integer pagestart = (page - 1)*limit;
        return mapper.selectByPage(title, pagestart, limit, flag);
    }

    //通过uid查询全部菜谱
    @Override
    public List<Menu> selectByUid(Integer uid, Integer flag) {
        return mapper.selectByUid(uid, flag);
    }

    //更改菜谱状态
    @Override
    public boolean updateByMid(Integer id, Integer flag) {
        return mapper.updateByMid(id, flag) > 0;
    }

    //收藏
    @Override
    public boolean updatecollect(Integer id) {
        return mapper.updatecollect(id) > 0;
    }


    //按分类查询
    @Override
    public PageVo<Menu> selectByType(Integer tid, Integer page, Integer limit) {
        return mapper.selectByType(tid,(page - 1)*limit,limit);
    }
}
