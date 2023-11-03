package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-11-03
 * Time:11:08
 */

@RequestMapping("/message")
@RestController
public class MessageController {
    private List<MessageInfo> messageInfos = new ArrayList<>();
    @RequestMapping("/publish")
    public Boolean publishMessage(MessageInfo messageInfo) {
        //进行参数的校验
        if (!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
        || !StringUtils.hasLength(messageInfo.getSay())) {
            return false;
        }
        //添加留言
        messageInfos.add(messageInfo);
        return true;
    }

    @RequestMapping("/getMessageInfo")
    public List<MessageInfo> getMessageInfo() {
        return messageInfos;
    }
}
