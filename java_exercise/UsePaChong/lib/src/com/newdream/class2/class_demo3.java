package com.newdream.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:14:54
 */
public class class_demo3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.manage().window().maximize();

        //通过绝对路径做定位
        Thread.sleep(2000);
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/a[2]/")).click();
        //2

        //3

        //4 使用xpath属性定位
        driver.findElement(By.xpath("//a[@href='http://map.baidu.com']")).click();

        //5

    }
}
