package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public static WebDriver DriverChrome(){
        if (driver == null){
            String currentDir = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", currentDir);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
