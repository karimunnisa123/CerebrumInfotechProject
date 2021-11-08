package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.BrowserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import static util.ConfigReader.getBrowser;
import static util.ConfigReader.getUrl;

public class BaseClass {

    public BrowserFactory browserFactory;


    //@Before
    public void launchBrowser() throws IOException {
        browserFactory = new BrowserFactory();
        browserFactory.initDriver(getBrowser(), getUrl());

    }

 //  @After
     public void quitBrowser() {
        BrowserFactory.getDriver().close();
    }

   public static String getScenarioName(Scenario scenario){
        return scenario.getName().replaceAll(" ","_");
    }

    @Attachment( value = "Failed Test ScreenShot", type = "image/png")
    public void saveScreenShot(WebDriver driver, Scenario scenario){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        String fileName = getScenarioName(scenario);
        File scr=screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr, new File("target/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 //   @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            saveScreenShot(BrowserFactory.getDriver(),scenario);
            try {
                FileInputStream inputStream = new FileInputStream("target/screenshots/" + getScenarioName(scenario) + ".png");
                Allure.addAttachment("Failed Test Screenshot",inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Allure.addAttachment("Failed Scenario Name",getScenarioName(scenario));
        }
        BrowserFactory.getDriver().quit();
    }


     /*       //take screenshot
          // String screenshotName = scenario.getName().replaceAll(" ", "_");
           // byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
           // scenario.attach(sourcePath, "image/png", screenshotName);
    //we can use attachment from allure also to generate screenshot
        BrowserFactory.getDriver();
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File scr=((TakesScreenshot)BrowserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr,new File("target/screenshots/" + scenario + ".jpg") );
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


        }
    } */


}


