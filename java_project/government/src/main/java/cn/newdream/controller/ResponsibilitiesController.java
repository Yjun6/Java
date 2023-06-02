package cn.newdream.controller;

import cn.newdream.entity.Responsibilities;
import cn.newdream.service.IResponsibilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:23:35
 */
@Controller
public class ResponsibilitiesController {
    @Autowired
    private IResponsibilitiesService responsibilitiesService;

    @RequestMapping("/about_order")
    public String toResponsibilities(Map map){
        List<Responsibilities> responsibilitiesList = responsibilitiesService.queryResponsibilitiesAll();
        map.put("responsibilitiesList",responsibilitiesList);
        return "about_order";
    }
}
