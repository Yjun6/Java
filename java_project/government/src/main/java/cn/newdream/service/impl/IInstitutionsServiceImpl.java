package cn.newdream.service.impl;

import cn.newdream.entity.Institutions;
import cn.newdream.mapper.IInstitutionsMapper;
import cn.newdream.service.IInstitutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:15:05
 */
@Service
public class IInstitutionsServiceImpl implements IInstitutionsService {

    //注入映射接口
    @Autowired
    private IInstitutionsMapper institutionsMapper;

    @Override
    public List<Institutions> queryInstitutionsAll() {
        return institutionsMapper.queryInstitutionsAll();
    }

}
