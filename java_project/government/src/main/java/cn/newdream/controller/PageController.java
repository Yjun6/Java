package cn.newdream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：页面跳转controller
 * 作者：wangcz
 * 时间：2023年04月19日 10:47
 */
@Controller
public class PageController {


    @RequestMapping("page_{url}")
    public String toPage(@PathVariable("url") String page) {
        // 在转发前会应用视图解析器，前面加前缀，后面加后缀，
        // 最后组成一个完成的url进行转发
        return page;
    }
}
