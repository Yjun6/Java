package cn.newdream.controller;

import cn.newdream.entity.Institutions;
import cn.newdream.entity.Page;
import cn.newdream.mapper.IPageMapper;
import cn.newdream.service.IInstitutionsService;
import cn.newdream.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:16:44
 */
@Controller
public class Page1Controller {

    @Autowired
    private IPageService pageService;

    @RequestMapping("/contact")
    public String toPage(Map map){
        List<Page> pageList = pageService.queryPageAll();
        map.put("pageList",pageList);
        return "contact";
    }
}
