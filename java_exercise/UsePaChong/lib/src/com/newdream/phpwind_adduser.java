package com.newdream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:11:39
 */
public class phpwind_adduser {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://47.107.178.45/phpwind/index.php?m=bbs");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("立即注册")).click();

       // driver.findElement(By.className("btn.btn_big.btn_submit.mr20")).click();
        driver.findElement(By.xpath("/html/body/script[1]")).click();
//        driver.findElement(By.name("YuJie")).click();
//        driver.findElement(By.id("203105Yu")).click();
//        driver.findElement(By.id("203105Yu")).click();
//        driver.findElement(By.id("2081517335@qq/com")).click();
//
//        driver.findElement(By.linkText("同意以下协议并注册")).click();
        Thread.sleep(200);




    }
}
