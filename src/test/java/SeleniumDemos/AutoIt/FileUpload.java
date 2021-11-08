package SeleniumDemos.AutoIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class FileUpload {
    public static void main(String args[]) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.photobox.co.uk/upload");
        Actions action=new Actions(driver);
        WebElement file= driver.findElement(By.xpath("//*[@id='device-info']/label"));
        action.moveToElement(file).click().perform();

        Runtime.getRuntime().exec("D:\\karimun\\AutoItExamples\\FileUploadScript.exe");
        Thread.sleep(5000);
      //  driver.close();
    }
}