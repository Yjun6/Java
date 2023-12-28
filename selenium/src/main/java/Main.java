import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
//        test07();
//        test08();

//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    private static void test5() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("");
    }

    private static void test4() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("file:///D:/Documents/code/Java/selenium/src/main/resources/static/test03.html");
        Select select = new Select(webDriver.findElement(By.cssSelector("#ShippingMethod")));
        select.selectByValue("10.69");
    }

    private static void test3() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("file:///D:/Documents/code/Java/selenium/src/main/resources/static/test02.html");
        //为了解决标签嵌套问题 需要先进行转换
        webDriver.switchTo().frame("f1");
        webDriver.findElement(By.cssSelector("body > div > div > a")).click();
    }

    private static void test2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("file:///D:/Documents/code/Java/selenium/src/main/resources/static/inner.html");
        webDriver.findElement(By.cssSelector("body > div > div > a")).click();
    }

    //测试复选框
    private static void test1() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("file:///D:/Documents/code/Java/selenium/src/main/resources/static/test01.html");
        webDriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
        List<WebElement> elements = webDriver.findElements(By.xpath("//div/div/input"));
        for(int i=0; i<elements.size(); i++) {
            if ("checkbox".equals(elements.get(i).getAttribute("type"))) {
                //相等
                elements.get(i).click();
            }
        }
        Thread.sleep(5000);
        for(int i=0; i<elements.size(); i++) {
            if ("radio".equals(elements.get(i).getAttribute("type"))) {
                //相等
                elements.get(i).click();
            }
        }
    }

    private static void test08() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //打开百度
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");
        //搜索富婆成功法决
        driver.findElement(By.cssSelector("#kw")).sendKeys("富婆成功法决");
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(3000);
        //找到对应的图片链接
        WebElement element = driver.findElement(By.xpath("//*[@id=\"s_tab\"]/div/a[2]"));
        //鼠标右击
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        //contextClick -- 右击  perform -- 执行
        actions.moveToElement(element).contextClick().perform();
    }

    private static void test07() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //打开百度
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");
        //搜索富婆成功法决
        driver.findElement(By.cssSelector("#kw")).sendKeys("富婆成功法决");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"A");
        Thread.sleep(3000);
        //清空
        driver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"X");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"V");
    }

    private static void test06() throws InterruptedException {
        //创建驱动
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //打开百度
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");
        //搜索富婆成功法决
        driver.findElement(By.cssSelector("#kw")).sendKeys("富婆成功法决");
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(3000);
        //回退
        driver.navigate().back();
        Thread.sleep(3000);
        //刷新页面
        driver.navigate().refresh();
        Thread.sleep(3000);
        //前进
        driver.navigate().forward();
        Thread.sleep(3000);
        //修改滚动条
        ((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=10000");
        //界面放大 全屏 缩小
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(700,700));
    }

    private static void test05() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.baidu.com");
//        WebElement element = webDriver.findElement(By.xpath("/html/head/title"));
        //显示等待
        WebDriverWait wait = new WebDriverWait(webDriver,2);
        wait.until(ExpectedConditions.titleIs("百度一下，你就知道"));

    }

    private static void test04() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));
        element.sendKeys("有钱人");
        webDriver.findElement(By.cssSelector("#su")).click();
        //隐式等待
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        webDriver.findElement(By.cssSelector("#kw")).clear();

    }

    private static void test03() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//span[2]//input"));
        if ("百度一下".equals(element.getAttribute("value"))) {
            System.out.println("匹配成功");
        } else {
            System.out.println("不成功   " + element.getAttribute("value"));
        }
    }

    //验证测试结果
    private static void test02() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.cssSelector("#kw"));
        element.sendKeys("我爱中国");
        //提交 submit() -- 只支持form表单
        driver.findElement(By.cssSelector("#su")).click();
        //校验
        List<WebElement> elements = driver.findElements(By.cssSelector("em"));
        System.out.println(elements);
        for (WebElement element1 : elements) {
            System.out.println(element1.getText());
            if (!element1.getText().contains("中国")) {
                System.out.println("不匹配");
            } else {
                System.out.println("匹配正确");
            }
        }
    }

    private static void test01() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://www.baidu.com");
        //找到百度的搜索框
        //通过类选择器
//        WebElement element = webDriver.findElement(By.cssSelector("#kw"));
//        element.sendKeys("类选择器");
        //通过path
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));
        element.sendKeys("xpath");

        element = webDriver.findElement(By.xpath("//*[@id=\"su\"]"));
        element.click();
    }

}
