package com.example.demo.service;

import com.example.demo.dao.CaptchaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaptchaService {

    @Autowired
    private CaptchaMapper captchaMapper;

    public String selectcaptcha() {
        return captchaMapper.selectcaptcha();
    }

    public int insertcaptcha(String captcha) {
        return captchaMapper.insertcaptcha(captcha);
    }
}
