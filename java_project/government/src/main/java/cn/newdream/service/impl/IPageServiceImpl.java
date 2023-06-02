package cn.newdream.service.impl;

import cn.newdream.entity.Page;
import cn.newdream.mapper.IPageMapper;
import cn.newdream.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:16:29
 */
@Service
public class IPageServiceImpl implements IPageService {

    @Autowired
    private IPageMapper pageMapper;

    @Override
    public List<Page> queryPageAll() {
        return pageMapper.queryPageAll();
    }

}
