package cn.newdream.controller;

import cn.newdream.mapper.IProcessMapper;
import cn.newdream.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:19:
 * 23
 */

@Controller
public class ProcessController {
    @Autowired
    private IProcessService processService;

    @RequestMapping("/contact_process")
    public String toProcess(Map map){
        List<Process> processList = processService.queryProcessAll();
        map.put("processList",processList);
        return "contact_process";
    }

}
