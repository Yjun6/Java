package cn.newdream.service;

import cn.newdream.entity.Notice;
import cn.newdream.entity.Zfdtb;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-31
 * Time:17:03
 */

public interface INoticeService {
    //查询最新发布的8条通知通告
    List<Notice> queryNoticeTop8();

    //根据id查询执法动态
    Notice queryNoticeById(int id);

    //查询所有的执法动态
    List<Notice> queryNoticeAll();
}
