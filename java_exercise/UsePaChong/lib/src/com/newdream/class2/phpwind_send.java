package com.newdream.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:17:00
 */
public class phpwind_send {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        WebDriver el = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div/nav/nav/div/div[3]/div[1]/div/div/div[2]/"));
        driver.switchTo().frame(el);
    }
}
