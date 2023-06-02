package cn.newdream.service.impl;

import cn.newdream.entity.Ggsd;
import cn.newdream.entity.Notice;
import cn.newdream.mapper.IGgsdMapper;
import cn.newdream.mapper.INoticeMapper;
import cn.newdream.service.IGgsdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:10:04
 */
@Service
public class IGgsdServiceImpl implements IGgsdService {

    @Autowired
    private IGgsdMapper ggsdMapper;

    @Override
    public List<Ggsd> queryGgsdTop8() {
        return ggsdMapper.queryGgsdTop8();
    }

    //根据id查询公告送达
    @Override
    public Ggsd queryGgsdById(int id) {
        return ggsdMapper.queryGgsdById(id);
    }

    @Override
    public List<Ggsd> queryGgsdAll() {
        return ggsdMapper.queryGgsdAll();
    }



}
