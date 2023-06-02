package cn.newdream.service.impl;

import cn.newdream.entity.Zfdtb;
import cn.newdream.mapper.IZfdtb;
import cn.newdream.service.IzfdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Service: 映射接口mapper
 * User:Yu
 * Date:2023-05-31
 * Time:9:25
 */

@Service
public class IzfdtServiceImpl implements IzfdtService {

    //注入执法动态的映射接口
    @Autowired
    private IZfdtb zfdtb;

    @Override
    public List<Zfdtb> queryTop8() {
        return zfdtb.queryTop8();
    }

    /*
    * 根据id查询执法动态
    * */
    @Override
    public Zfdtb queryById(int id) {
        return zfdtb.queryById(id);
    }

    /*
    * 查询所有的执法动态
    * */
    @Override
    public List<Zfdtb> queryAll() {
        return zfdtb.queryAll();
    }
}
