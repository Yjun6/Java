package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-10
 * Time:20:37
 */

@RequestMapping("/admin")
@RestController
public class CaptchaController {

    private static final String KAPTCHA_SESSION_KEY = "HOME_KAPTCHA_SESSION_KEY";
    private static final String  HOME_KAPTCHA_SESSION_DATE = "HOME_KAPTCHA_SESSION_DATE";
    private static final Long SESSION_TIMEOUT = 60 * 1000L;//验证码过期时间 Ms
    //true 验证成功 false 验证失败
    //默认session中已经存在验证码
    @RequestMapping("/check")
    public Boolean check(String captcha, HttpSession session) {
        //1.取出
        if (!StringUtils.hasLength(captcha)) {
            return false;
        }
        //2.获取
        String saveCaptcha = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        Date saveDate = (Date)session.getAttribute(HOME_KAPTCHA_SESSION_DATE);
        if (captcha.equals(saveCaptcha)) {
            if (saveCaptcha == null || System.currentTimeMillis()-saveDate.getTime() > SESSION_TIMEOUT) {
                return false;
            }
            return true;
        }
        return false;
    }
}
