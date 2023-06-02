package cn.newdream.controller;

import cn.newdream.entity.Notice;
import cn.newdream.entity.Zfdtb;
import cn.newdream.mapper.INoticeMapper;
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
 * Time:10:22
 */

@Controller
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    /*
    *
    * 根据id查询
    * 公告详情
    * */
    @RequestMapping("/queryNoticeById")
    public String queryNoticeById(int id, Map map){
        Notice notice = noticeService.queryNoticeById(id);
        //保存
        map.put("notice",notice);

        return "news_notice";
    }

    @RequestMapping("/queryNoticeAll")
    public String queryNoticeAll(Map map){
        //查询
        List<Notice> noticeList = noticeService.queryNoticeAll();
        //保存
        map.put("noticeList",noticeList);
        return "newslist_notice";
    }


}
