package cn.newdream.service;

import cn.newdream.entity.Page;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:16:29
 */
public interface IPageService {
    //查询所有的
    List<Page> queryPageAll();
}
