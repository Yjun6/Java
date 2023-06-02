package cn.newdream.service.impl;

import cn.newdream.mapper.IProcessMapper;
import cn.newdream.service.IPageService;
import cn.newdream.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:19:21
 */
@Service
public class IProcessServiceImpl implements IProcessService {

    @Autowired
    private IProcessMapper processMapper;

    @Override
    public List<Process> queryProcessAll() {
        return processMapper.queryProcessAll();
    }
}
