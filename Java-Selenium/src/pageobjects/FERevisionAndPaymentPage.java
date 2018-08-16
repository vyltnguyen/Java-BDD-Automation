package pageobjects;

import support.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FERevisionAndPaymentPage {
    WebDriver driver = Driver.DriverChrome();
    public FERevisionAndPaymentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String verifyValueOfContactInformation(String labelElement, String expectedResult) {
        String xpathFieldValue = "//span[.='" + labelElement +"']/following::span[1]";
        WebElement lblElement = driver.findElement(By.xpath(xpathFieldValue));
        String actualResult = lblElement.getText();
        System.out.print("  Verify value of " + labelElement + " :");
        String result;
        if (actualResult.contentEquals(expectedResult)){
            System.out.println("Test Passed!");
            result = "Test Passed!";
        } else {
            System.out.println("Test Failed");
            result = "Test Failed!";
        }
        return result;
    }

    public String verifyValueOfApplicants(int positionElement, String elementName, String expectedResult) {
        String xpathFieldValue = "//table[@id ='review_order_applicants']//td[" + positionElement + "]";
        WebElement lblElement = driver.findElement(By.xpath(xpathFieldValue));
        String actualResult = lblElement.getText();
        String result;
        System.out.print("  Verify value of " + elementName + " :");
        if (actualResult.contentEquals(expectedResult)){
            System.out.println("Test Passed!");
            result = "Test Passed!";

        } else {
            System.out.println("Test Failed!");
            result = "Test Failed!";
        }
        return result;
    }
}
