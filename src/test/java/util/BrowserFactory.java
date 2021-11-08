package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static util.ConfigReader.*;

public class BrowserFactory {
    public  static WebDriver driver;
    public static String url;

    static {
        try {
            url = "https://"+ getSauceLabUserName()+":"+getSauceLabAccessKey()+getSauceLabLink();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initDriver(String browserName, String appUrl) throws IOException {

        //String browserName="chrome";
        System.out.println("browser value is: " + browserName);
        if (getRemote().toLowerCase().equals("false")) {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                   // System.out.println("Enter valid browser from the list : chrome,firefox,edge");
                    throw new IllegalStateException("Unexpected value:" + browserName.toLowerCase()+"supported browsers : chrome,firefox,edge");
                  //  break;
            }
            driver.get(appUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }else{
            DesiredCapabilities caps;
            switch (browserName.toLowerCase()){
                case "chrome":
                    caps=DesiredCapabilities.chrome();
                    break;
                case "firefox":
                    caps=DesiredCapabilities.firefox();
                    break;
                case "edge":
                    caps=DesiredCapabilities.edge();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value:" + browserName.toLowerCase());
            }

            caps.setCapability("platform",getPlatform());
            caps.setCapability("version", getBrowserVersion());
            caps.setCapability("name",getTestName());

            try {
                driver=new RemoteWebDriver(new URL(url),caps);
            }catch (MalformedURLException e){
                e.printStackTrace();
            }

            driver.get(appUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        }
    }


     public static WebDriver getDriver(){
        return driver;
    }

}

