package com.edu.web.controller;

import com.edu.commons.vo.JsonModel;
import com.edu.pojo.History;
import com.edu.pojo.User;
import com.edu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    private HistoryService service;

    //查询自己所有浏览记录
    @RequestMapping("/queryhistory.do")
    public JsonModel queryhistory(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<History> histories = service.selectByUid(user.getId());
        if(null != histories && histories.size() > 0){

            return  JsonModel.createJs(0,"ok",histories);
        }

        return JsonModel.error();
    }

    //删除指定记录
    @RequestMapping("/delhistory.do")
    public JsonModel delhistory(Integer mid){
        if(service.deleteByMid(mid)){
            return JsonModel.ok();
        }
        return JsonModel.error();
    }
    //删除全部记录
    @RequestMapping("/delallhistory.do")
    public JsonModel delallhistory(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        boolean res = service.deleteByUid(user.getId());
        if(res){
            return JsonModel.ok();
        }
        return JsonModel.error();
    }
    //更新记录时间
    @RequestMapping("/modifyviewtime.do")
    public JsonModel modifyviewtime(Integer mid){
        if(service.updateByMid(mid)){
            return JsonModel.ok();
        }
        return JsonModel.error();
    }

}
