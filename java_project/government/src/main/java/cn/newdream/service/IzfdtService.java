package cn.newdream.service;

import cn.newdream.entity.Zfdtb;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-31
 * Time:9:23
 */
public interface IzfdtService {
    //查询最新的8条执法动态
    List<Zfdtb> queryTop8();

    //根据id查询执法动态
    Zfdtb queryById(int id);

    //查询所有的执法动态
    List<Zfdtb> queryAll();
}
