package pageobjects.FE;

import support.CommonAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FELoginPage {
    @FindBy(xpath =  "//button[.= 'Login']")
    public WebElement btnLogin;


    @FindBy(xpath =  "//input[@name='username']")
    public WebElement txtEmail;

    @FindBy(xpath =  "//input[@name='password']")
    public WebElement txtPass;

    public FELoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
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
