package com.example.demo.model;

import com.example.demo.utils.DateUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.util.Date;

/**
 * 博客实体类
 */
@Data
public class BlogInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
    /**
     * 该参数表示 当前博客作者是否是当前用户
     * 注意：boolean 类型的属性  get 和 set 方法 是特殊的
     * */
    private boolean isLoginUser;

    public String getCreateTime() {
        return DateUtils.formatDate(createTime);
    }

    public String getUpdateTime() {
        return DateUtils.formatDate(updateTime);
    }


}
