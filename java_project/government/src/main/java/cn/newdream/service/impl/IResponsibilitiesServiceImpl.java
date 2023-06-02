package cn.newdream.service.impl;

import cn.newdream.entity.Responsibilities;
import cn.newdream.mapper.IResponsibilitiesMapper;
import cn.newdream.service.IResponsibilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:23:33
 */
@Service
public class IResponsibilitiesServiceImpl implements IResponsibilitiesService {

    //注入执法动态的映射接口
   @Autowired
   private IResponsibilitiesMapper responsibilitiesMapper;

    @Override
    public List<Responsibilities> queryResponsibilitiesAll() {
        return responsibilitiesMapper.queryResponsibilitiesAll();
    }
}
