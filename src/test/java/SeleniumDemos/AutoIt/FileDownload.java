package SeleniumDemos.AutoIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class FileDownload {
    public static void main(String args[]) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/downloads/");
        driver.findElement(By.linkText("4.0.0")).click();

        Runtime.getRuntime().exec("D:\\karimun\\AutoItExamples\\FileDownloadScript.exe");
        Thread.sleep(5000);



    }

}