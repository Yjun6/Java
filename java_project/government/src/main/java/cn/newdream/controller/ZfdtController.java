package cn.newdream.controller;

import cn.newdream.entity.Ggsd;
import cn.newdream.entity.Notice;
import cn.newdream.entity.Zfdtb;
import cn.newdream.service.IGgsdService;
import cn.newdream.service.INoticeService;
import cn.newdream.service.IzfdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-31
 * Time:9:32
 */

@Controller
public class ZfdtController {

    @Autowired
    private IzfdtService zfdtService;

    @Autowired
    private INoticeService noticeService;

    @Autowired
    private IGgsdService ggsdService;

    /*
    * 查询最新发布的8条执法动态
    * @return
    * */
    @RequestMapping("/index")
    public String index(Map map){
        //查询数据
        List<Zfdtb> zfdtbList = zfdtService.queryTop8();
        //保存数据
        map.put("zfdtbList",zfdtbList);

        //查询数据
        List<Notice> noticeList = noticeService.queryNoticeTop8();
        //保存数据
        map.put("noticeList",noticeList);
        //跳到index.html页面显示

        //查询
        List<Ggsd> ggsdList = ggsdService.queryGgsdTop8();
        //保存
        map.put("ggsdList",ggsdList);

        return "index";
    }

    /*
    * 根据id查询执法动态
    * */
    @RequestMapping("/zfdtDetail")
    public String zfdtDetail(int id,Map map){
        //查询
        Zfdtb zfdtb = zfdtService.queryById(id);
        //保存
        map.put("zfdtb",zfdtb);
        //跳到news_xq.html页面显示
        return "news_xq";
    }

    /*
    * 查询所有执法动态*/
    @RequestMapping("/queryAllZfdt")
    public String queryAllZfdt(Map map){
        //查询
        List<Zfdtb> zfdtbList = zfdtService.queryAll();
        //保存
        map.put("zfdtbList",zfdtbList);
        return "newslist";
    }

}
