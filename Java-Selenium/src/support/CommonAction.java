package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class CommonAction {
    WebDriver driver = Driver.DriverChrome();
    public void navigateToUrl(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void goToFunc(WebElement mnuMain, String mainName, String subName){
        PageFactory.initElements(driver, this);
        String xpathMenu = "//a[contains(text(),'" + mainName + "')]";
        mnuMain.findElement(By.xpath(xpathMenu)).click();
        String xpathSubMenu = "//a[.='" + subName + "']";
        mnuMain.findElement(By.xpath(xpathMenu)).findElement(By.xpath(xpathSubMenu)).click();
    }

    public void goToFunc(WebElement mnuMain, String mainName){
        String xpathMenu = "//a[contains(text()," + mainName + "')]";
        mnuMain.findElement(By.xpath(xpathMenu)).click();
    }

    public void selectOptionByText(WebElement dropDown, String optionName){
        Select option = new Select(dropDown);
        option.selectByVisibleText(optionName);
    }
    public void selectOptionByValue(WebElement dropDown, String optionValue){
        Select option = new Select(dropDown);
        option.selectByValue(optionValue);
    }

    public void selectOptionByIndex(WebElement dropDown, int optionIndex){
        Select option = new Select(dropDown);
        option.selectByIndex(optionIndex);
    }

    public void clickAndWait(WebElement objectElement, int seconds){
        objectElement.click();
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    public void clickAndWait(WebElement objectElement){
        objectElement.click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public void setText(WebElement ifrElement, WebElement txtElement, String string){
        driver.switchTo().frame(ifrElement);
        txtElement.sendKeys(string);
        txtElement.click();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
    }
    public void setText(WebElement txtElement, String string){
        txtElement.sendKeys(string);
        txtElement.click();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
    }

    public String convertDate(String date, String inputPattern, String outputPattern){
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());

        Date datetime;
        String stringDateTime = "";
        try {
            datetime = inputFormat.parse(date);
            stringDateTime = outputFormat.format(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stringDateTime;
    }

    public  void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public  void waitForElementClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
