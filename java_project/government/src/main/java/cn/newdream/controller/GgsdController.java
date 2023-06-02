package cn.newdream.controller;

import cn.newdream.entity.Ggsd;
import cn.newdream.entity.Notice;
import cn.newdream.service.IGgsdService;
import cn.newdream.service.INoticeService;
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
 * Time:11:19
 */
@Controller
public class GgsdController {

    @Autowired
    private IGgsdService ggsdService;

    /*
     *
     * 根据id查询公告送达
     * */
    @RequestMapping("/queryGgsdById")
    public String queryGgsdById(int id, Map map){
        Ggsd ggsd = ggsdService.queryGgsdById(id);
        //保存
        map.put("ggsd",ggsd);

        return "news_ggsd";
    }

    @RequestMapping("/queryGgsdAll")
    public String queryGgsdAll(Map map){
        //查询
        List<Ggsd> ggsdList = ggsdService.queryGgsdAll();
        //保存
        map.put("ggsdList",ggsdList);
        return "newslist_ggsd";
    }

}
