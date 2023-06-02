package cn.newdream.service;

import cn.newdream.entity.Officers;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:19:17
 */
public interface IOfficersService {
    //查询所有的执法人员
    List<Officers> queryOfficersAll();
}
