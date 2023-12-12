package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CaptchaMapper {
    @Select("select captcha from captcha")
    String selectcaptcha();

    @Insert("insert into captcha(captcha) values(#{captcha})")
    int insertcaptcha(@Param("captcha") String captcha);
}
