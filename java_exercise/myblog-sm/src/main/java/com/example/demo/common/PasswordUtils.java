package com.example.demo.common;


import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * 密码工具类
 * 加盐密码
 */
public class PasswordUtils {

    /**加盐加密
     * 加盐不可逆
     */
    public static String encrypt(String password) {
        //1.盐值
        //将盐值转为32位
        String salt = UUID.randomUUID().toString().replace("-","");
        //2.将盐值+密码进行md5得到最终密码
        String finalPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        //3.将盐值和最终密码进行返回
        return salt+"$"+finalPassword;
    }

    /**
     * 加盐密码验证
     *      * 1.将数据库中的盐值和待验证密码进行加盐
     *      * 2.比较数据库的最终密码
     * @param      password 待验证的密码
     *  @param     dbpassword 数据库中的密码=盐值+分隔符+最终密码
     * */
    public static boolean decrypt(String password, String dbpassword) {
        if (!StringUtils.hasLength(password) || !StringUtils.hasLength(dbpassword)
        || dbpassword.length() != 65) {
            //加盐后的密码一定是65位的 32+1+32
            return false;
        }
        //1.得到盐值  $需要转义
        String[] dbPasswordArray = dbpassword.split("\\$");
        if (dbPasswordArray.length != 2) {
            return false;
        }
        //得到盐值
        String salt = dbPasswordArray[0];
        //最终正确密码
        String dbFinalPassword = dbPasswordArray[1];
        //2.加密
        String finalPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        //3.比较
        return finalPassword.equals(dbFinalPassword);
    }

}
