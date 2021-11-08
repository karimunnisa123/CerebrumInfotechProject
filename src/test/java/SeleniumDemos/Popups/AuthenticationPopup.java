package SeleniumDemos.Popups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopup {

    private static final String username="admin";
    private static final String password="admin";

    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

        String msg=driver.findElement(By.cssSelector("div#content p")).getText();
        Thread.sleep(2000);
        System.out.println(msg);

        driver.close();
    }
}
