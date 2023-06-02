package cn.newdream.controller;

import cn.newdream.entity.Institutions;
import cn.newdream.entity.Officers;
import cn.newdream.mapper.IInstitutionsMapper;
import cn.newdream.service.IInstitutionsService;
import cn.newdream.service.IOfficersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:15:08
 */
@Controller
public class InstitutionsController {

    @Autowired
    private IInstitutionsService institutionsService;

    @RequestMapping("/about")
    public String toInstitutions(Map map){
        List<Institutions> institutionsList = institutionsService.queryInstitutionsAll();
        map.put("institutionsList",institutionsList);
        return "about";
    }
}
