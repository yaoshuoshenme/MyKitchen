package com.edu.web.controller;

import com.edu.commons.vo.JsonModel;
import com.edu.pojo.MenuType;
import com.edu.service.HistoryService;
import com.edu.service.MenuTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuTypeController {
    @Autowired
    private MenuTypeService service;



    //新增
    @RequestMapping("/addtype.do")
    @ResponseBody
    public JsonModel addtype(MenuType menuType){
        if(service.insert(menuType)){
            return JsonModel.ok();
        }
        return JsonModel.error();
    }

    //查询一级
    @RequestMapping("/queryparenttype.do")
    @ResponseBody
    public JsonModel queryparenttype(){
        JsonModel js = new JsonModel();
        List<MenuType> menuTypes = service.selectAllParent();
        if(menuTypes != null && menuTypes.size() > 0){
            js.setCode(0);
            js.setData(menuTypes);

            return js;
        }
        return JsonModel.error();
    }

    //查询二级
    @RequestMapping("/querybyparentid.do")
    @ResponseBody
    public JsonModel querybyparentid(Integer pid){
        JsonModel js = new JsonModel();
        List<MenuType> menuTypes = service.selectAllByParentId(pid);
        if(menuTypes != null && menuTypes.size() > 0){
            js.setCode(0);
            js.setData(menuTypes);

            return js;
        }
        return JsonModel.error();
    }

    //热门分类
}
