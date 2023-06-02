package cn.newdream.mapper;

import cn.newdream.entity.Institutions;
import cn.newdream.entity.Officers;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:15:03
 */
public interface IInstitutionsMapper {

    //查询所有的
    List<Institutions> queryInstitutionsAll();
}
