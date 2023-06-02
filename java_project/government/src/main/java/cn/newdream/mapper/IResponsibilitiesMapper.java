package cn.newdream.mapper;

import cn.newdream.entity.Notice;
import cn.newdream.entity.Responsibilities;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:23:31
 */
public interface IResponsibilitiesMapper {
    //查询所有
    List<Responsibilities> queryResponsibilitiesAll();
}
