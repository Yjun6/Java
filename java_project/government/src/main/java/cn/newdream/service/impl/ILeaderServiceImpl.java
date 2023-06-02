package cn.newdream.service.impl;

import cn.newdream.entity.Leader;
import cn.newdream.mapper.ILeaderMapper;
import cn.newdream.mapper.IProcessMapper;
import cn.newdream.service.ILeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:21:47
 */
@Service
public class ILeaderServiceImpl implements ILeaderService {

    @Autowired
    private ILeaderMapper leaderMapper;

    @Override
    public List<Leader> queryLeaderAll() {
        return leaderMapper.queryLeaderAll();
    }
}
