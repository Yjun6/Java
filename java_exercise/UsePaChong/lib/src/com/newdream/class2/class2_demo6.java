package com.newdream.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:16:22
 */
public class class2_demo6 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///E:/");
        driver.manage().window().maximize();

        driver.switchTo().frame("top");
        //driver.findElement().
    }
}
