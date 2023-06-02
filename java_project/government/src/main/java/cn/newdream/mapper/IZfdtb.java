package cn.newdream.mapper;

import cn.newdream.entity.Zfdtb;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:执法动态接口
 * User:Yu
 * Date:2023-05-31
 * Time:9:01
 */
public interface IZfdtb {
    //查询最新的8条执法动态
    List<Zfdtb> queryTop8();

    //根据id查询执法动态
    Zfdtb queryById(int id);

    //查询所有的执法动态
    List<Zfdtb> queryAll();
}
