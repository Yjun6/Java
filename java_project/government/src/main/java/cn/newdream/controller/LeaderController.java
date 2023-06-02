package cn.newdream.controller;

import cn.newdream.entity.Institutions;
import cn.newdream.entity.Leader;
import cn.newdream.service.IInstitutionsService;
import cn.newdream.service.ILeaderService;
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
 * Time:22:16
 */
@Controller
public class LeaderController {
    @Autowired
    private ILeaderService leaderService;

    @RequestMapping("/about_leader")
    public String toLeader(Map map){
        List<Leader> leaderList = leaderService.queryLeaderAll();
        map.put("leaderList",leaderList);
        return "about_leader";
    }
}
