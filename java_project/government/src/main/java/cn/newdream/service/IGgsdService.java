package cn.newdream.service;

import cn.newdream.entity.Ggsd;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:9:58
 */
public interface IGgsdService {
    //查询最新发布的8条公告送达
    List<Ggsd> queryGgsdTop8();

    //根据id查询公告送达
    Ggsd queryGgsdById(int id);

    //查询所有的公告送达
    List<Ggsd> queryGgsdAll();
}
