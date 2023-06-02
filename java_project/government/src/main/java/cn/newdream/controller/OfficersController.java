package cn.newdream.controller;

import cn.newdream.entity.Officers;
import cn.newdream.service.INoticeService;
import cn.newdream.service.IOfficersService;
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
 * Time:22:24
 */
@Controller
public class OfficersController {

    @Autowired
    private IOfficersService officersService;

    @RequestMapping("/about_people")
    public String toOfficer(Map map){
        List<Officers> officersList = officersService.queryOfficersAll();
        map.put("officersList",officersList);
        return "about_people";
    }
}
