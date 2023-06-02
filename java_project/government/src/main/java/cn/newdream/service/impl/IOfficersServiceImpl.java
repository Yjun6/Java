package cn.newdream.service.impl;

import cn.newdream.entity.Officers;
import cn.newdream.mapper.IOfficersMapper;
import cn.newdream.service.IOfficersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:19:18
 */
@Service
public class IOfficersServiceImpl implements IOfficersService {

    //注入执法动态的映射接口
    @Autowired
    private  IOfficersMapper officersMapper;

    /*
     * 查询所有的执法动态
     * */
    @Override
    public List<Officers> queryOfficersAll() {
        return officersMapper.queryOfficersAll();
    }

}
