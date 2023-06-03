package com.newdream.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:14:24
 */
public class class2_demo2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.manage().window().maximize();

//        driver.findElement(By.className("s_ipt")).sendKeys("英雄就是跟普通人变态的变态");
//
//        Thread.sleep(2000);
//        driver.findElement(By.id("su")).click();

        Thread.sleep(2000);

        //driver.findElement(By.linkText("国家安全体系和能力现代化")).click();
        //driver.findElement(By.id("su")).click();

        driver.findElement(By.partialLinkText("hao")).click();



    }
}
