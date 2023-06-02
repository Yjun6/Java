package cn.newdream.mapper;

import cn.newdream.entity.Officers;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:22:33
 */
public interface IOfficersMapper {
    //查询所有的
    List<Officers> queryOfficersAll();
}
