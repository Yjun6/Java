package cn.newdream.mapper;

import cn.newdream.entity.Institutions;
import cn.newdream.entity.Page;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:16:28
 */
public interface IPageMapper {

    //查询所有的
    List<Page> queryPageAll();
}
