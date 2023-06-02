package cn.newdream.service.impl;

import cn.newdream.entity.Notice;
import cn.newdream.entity.Zfdtb;
import cn.newdream.mapper.INoticeMapper;
import cn.newdream.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Service调mapper
 * User:Yu
 * Date:2023-05-31
 * Time:17:05
 */
@Service
public class INoticeServiceImpl implements INoticeService {

    @Autowired
    private INoticeMapper noticeMapper;

    /*
    * 查询最近8条通知公告
    * */
    @Override
    public List<Notice> queryNoticeTop8() {
        return noticeMapper.queryNoticeTop8();
    }


    //根据id查询通知公告
    @Override
    public Notice queryNoticeById(int id) {
        return noticeMapper.queryNoticeById(id);
    }

    @Override
    public List<Notice> queryNoticeAll() {
        return noticeMapper.queryNoticeAll();
    }

}
