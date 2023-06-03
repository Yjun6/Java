package com.newdream.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class openBaidu {
    public static void main(String[] args) throws InterruptedException {

        //司机
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","D:\\java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        driver.manage().window().maximize();

        driver.findElement(By.name("wd")).sendKeys("good good study,day day up");

        Thread.sleep(2000);

        driver.findElement(By.id("su")).click();
    }
}
