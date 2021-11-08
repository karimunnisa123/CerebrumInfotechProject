package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   // public static String url="http://stgcerb.cerebruminfotech.com:9069/admin/";
    public static Properties getPropertyObject() throws IOException {

        FileInputStream fis = new FileInputStream("src/test/resources/Config/login.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop;
    }

    public static String getBrowser() throws IOException {
        return getPropertyObject().getProperty("browser");
    }

    public static String getUrl() throws IOException {
        return getPropertyObject().getProperty("url");
    }

    public static String getEmail() throws IOException {
        return getPropertyObject().getProperty("email");
    }

    public static String getPassword() throws IOException{
        return getPropertyObject().getProperty("password");
    }

    public static String getRemote() throws IOException {
        return getPropertyObject().getProperty("remote");
    }

    public static String getSauceLabUserName() throws IOException{
        return getPropertyObject().getProperty("sauceLab.userName");
    }

    public static String getSauceLabAccessKey() throws IOException {
        return getPropertyObject().getProperty("sauceLab.accessKey");
    }

    public static String getSauceLabLink() throws IOException {
        return getPropertyObject().getProperty("sauceLab.link");
    }

    public static String getPlatform() throws IOException {
        return getPropertyObject().getProperty("platform");
    }

    public static String getBrowserVersion() throws IOException {
        return getPropertyObject().getProperty("browser.version");
    }

    public static String getTestName() throws IOException {
        return getPropertyObject().getProperty("test.name");
    }


}
