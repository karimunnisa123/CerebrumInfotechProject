package SeleniumDemos.Popups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PermissionPopup {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
       options.addArguments("disable-notifications");

        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
       // driver.get("http://www.google.com");

      driver.get("https://web-push-book.gauntface.com/demos/notification-examples/");
        Thread.sleep(1000);

      driver.findElement(By.xpath("/html/body/main/p[3]/input")).click();



    }
}
