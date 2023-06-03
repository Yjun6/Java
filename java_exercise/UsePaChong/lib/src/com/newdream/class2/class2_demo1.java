package com.newdream.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import com.google.common.io.Files;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-02
 * Time:10:49
 */
public class class2_demo1 {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        driver.findElement(By.id("s-top-loginbtn")).click();
//        Thread.sleep(2000);
//        driver.navigate().refresh();
//        Thread.sleep(2000);
//        driver.navigate().back();
//        Thread.sleep(2000);
//        driver.navigate().forward();
//
//        //File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        Files.copy(screenShotFile, new File("D:/test20230602.png"));

        driver.findElement(By.name("wd")).sendKeys("12306");
        Thread.sleep(2000);

        driver.findElement(By.id("su")).click();
        Thread.sleep(4000);

        String URL = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println(URL);
        System.out.println(title);

        if(title.equals("12306_百度搜索")){
            System.out.println("检查标题，测试通过");
        }else{
            System.out.println("检查标题,测试失败");
        }

        if(URL.contains("12306")){
            System.out.println("检查URL，测试通过");
        }else{
            System.out.println("检查URL,测试失败");
        }

        //8
        driver.quit();
        //9


    }
}
