import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
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
