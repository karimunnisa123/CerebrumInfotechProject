package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {


    public static WebDriverWait webDriverWait(int waitTime) {
        return new WebDriverWait(BrowserFactory.getDriver(), waitTime);
    }

    public static void waitUntilVisible(WebElement element, int waitTime) {
        webDriverWait(waitTime).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilClickable(WebElement element, int waitTime) {
        webDriverWait(waitTime).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }



}