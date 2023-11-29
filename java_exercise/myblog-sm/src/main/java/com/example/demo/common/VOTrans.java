package com.example.demo.common;

import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.UserinfoVO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * UserinfoVO Userinfo互相转换
 */
@Component
public class VOTrans {
    public static void transVO(UserinfoVO userinfoVO, Userinfo userinfo){
        userinfoVO.setId(userinfo.getId());
        userinfoVO.setUsername(userinfo.getUsername());
        userinfoVO.setPassword(userinfo.getPassword());
        userinfoVO.setNickname(userinfo.getNickname());
        userinfoVO.setGender(userinfo.getGender());
        userinfoVO.setGithub(userinfo.getGithub());
        userinfoVO.setPhoto(userinfo.getPhoto());
        userinfoVO.setCreatetime(userinfo.getCreatetime());
        userinfoVO.setUpdatetime(userinfo.getUpdatetime());
        userinfoVO.setState(userinfo.getState());
    }
}
