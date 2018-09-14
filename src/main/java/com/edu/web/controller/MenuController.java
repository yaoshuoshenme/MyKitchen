package com.edu.web.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.edu.commons.utils.FileUtil;
import com.edu.commons.vo.JsonModel;
import com.edu.commons.vo.MenuStep;
import com.edu.commons.vo.PageVo;
import com.edu.pojo.History;
import com.edu.pojo.Menu;
import com.edu.pojo.User;
import com.edu.service.HistoryService;
import com.edu.service.MenuService;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Controller
public class MenuController {
    @Autowired
    private MenuService service;
    @Autowired
    private HistoryService historyService;

    //上传菜谱
    @PostMapping("/uploadmenu.do")
    public JsonModel uploadmenu(Menu menu, @RequestParam("photo") List<CommonsMultipartFile> photo, @RequestParam("vedio") CommonsMultipartFile vedio, HttpServletRequest request){
        List<CommonsMultipartFile> vediofile = new ArrayList<CommonsMultipartFile>();
        vediofile.add(vedio);
        //保存视频返回路径
        String vedios = FileUtil.toString(vediofile, request).get(0);
        //保存图片返回路径
        List<String> photos = FileUtil.toString(photo, request);
        //图片按顺序插入content
        List<MenuStep> menuSteps = (List<MenuStep>) JSONUtils.parse(menu.getContent());
        for(int i = 0; i < menuSteps.size(); i++){
            menuSteps.get(i).setPhoto(photos.get(i));
        }
        //重新赋值给menu
        menu.setContent(JSONUtils.toJSONString(menuSteps));
        //调用service保存
        boolean res = service.insert(menu) > 0;
        if(res){
            return JsonModel.ok();
        }

        return JsonModel.error();
    }

    //通过mid查询菜谱
    @RequestMapping("/menudetail.do")
    public JsonModel menudetail(Integer mid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        JsonModel js = new JsonModel();
        Menu menu = service.selectByMid(mid);
        if(null != menu){
            //把uid和mid存到浏览历史表
            History history = new History(user.getId(), mid);
            historyService.insert(history);

            //返回信息
            js.setMsg("ok");
            js.setCode(0);
            js.setData(menu);
            return js;
        }

        return JsonModel.error();
    }

    //搜索菜谱,默认按做的最多排名
    @RequestMapping("/querymenubytitle.do")
    public JsonModel querymenubytitle(String title,Integer page, Integer limit, Integer flag){
        PageVo<Menu> menuPageVo = service.selectByPage(title, page, limit, flag);
        JsonModel js = new JsonModel();
        if(null != menuPageVo){
            js.setCode(0);
            js.setData(menuPageVo);
            return js;
        }
        return JsonModel.error();
    }

    //查看指定用户所有菜谱
    @RequestMapping("/querymenubyuid.do")
    public JsonModel querymenubyuid(Integer uid){
        JsonModel js = new JsonModel();
        List<Menu> menus = service.selectByUid(uid,1);
        if(menus != null && menus.size() > 0){
            js.setData(menus);
            js.setCode(0);
            return js;
        }
        return JsonModel.error();
    }

    //查看草稿箱
    @RequestMapping("/querymenudraft.do")
    public JsonModel querymenudraft(Integer uid){
        JsonModel js = new JsonModel();
        List<Menu> menus = service.selectByUid(uid, 0);
        if(menus != null && menus.size() > 0){
            js.setData(menus);
            js.setCode(0);
            return js;
        }
        return JsonModel.error();
    }

    //更新菜谱状态，从草稿箱发布
    @RequestMapping("/pubmenudraft.do")
    public JsonModel pubmenudraft(Integer mid){
        if(service.updateByMid(mid, 1)){
            return JsonModel.ok();
        }
        return JsonModel.error();
    }
    //收藏，喜欢
    @RequestMapping("/likemenu.do")
    public JsonModel likemenu(Integer mid){
        boolean res = service.updatecollect(mid);
        if(res){
            return JsonModel.ok();
        }

        return JsonModel.error();
    }

    //按照分类查询

    @RequestMapping("/querybytype.do")
    public JsonModel querybytype(Integer tid, Integer page, Integer limit){
        PageVo<Menu> menuPageVo = service.selectByType(tid, page, limit);
        if(null != menuPageVo){
            return JsonModel.createJs(0,"ok",menuPageVo);
        }
        return JsonModel.error();
    }

}

1

