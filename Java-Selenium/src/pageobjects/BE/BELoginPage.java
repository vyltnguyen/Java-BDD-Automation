package pageobjects.BE;

import support.CommonAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BELoginPage {;

    @FindBy(xpath =  "//input[@name='email']")
    public WebElement txtEmail;

    @FindBy(xpath =  "//input[@name='password']")
    public WebElement txtPass;

    @FindBy(xpath =  "//button[.= 'Login']")
    public WebElement btnLogin;

    @FindBy(xpath =  "//div[contains(@class, 'alert')]")
    public WebElement lblMessage;

    public BELoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void checkMessage(String message,String attribute, WebElement object){
        String actualMessage =
                object.getAttribute(attribute).replaceAll("\n","");
        if (actualMessage.contentEquals(message)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
    }

    public void loginSuccessfully(boolean isNavigate,String baseUrl,String email, String password){
        if (isNavigate == false){
            CommonAction common = new CommonAction();
            common.navigateToUrl(baseUrl);
        }
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPass.clear();
        txtPass.sendKeys(password);
        btnLogin.click();
    }
}
