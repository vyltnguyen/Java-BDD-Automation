package testcase;

import support.CommonAction;
import org.openqa.selenium.WebDriver;
import pageobjects.BELoginPage;
import support.Driver;

public class BE002LoginToPageUnsuccessfully {
    private String baseUrl = "https://www.phptravels.net/admin";

    private String errorMessage1 = "Please fill out this field.";

    private String errorMessage2 = "The Email field must contain a valid email address.";

    private String errorMessage3 = "Invalid Login Credentials";

    private String invalidEmail1 = "abc";

    private String invalidEmail2 = "admin1@phptravels.com";

    private String invalidPass = "123";

    WebDriver driver = Driver.DriverChrome();

    public void loginUnsuccessfully() throws InterruptedException {
        // launch Chrome and direct it to the Base URL
        CommonAction common = new CommonAction();
        BELoginPage login = new BELoginPage(driver);

        common.navigateToUrl(baseUrl);
        /*=====================================================================================================================
         **************Start Test case: BE002-Login-Login to page unsuccessfully**********************/
        System.out.println("Start Test case: BE002-Login-Login to page unsuccessfully");
        /*-----------------------------------------------------------------------------------------
        VP1: 'Please fill out this field" message is displayed.
        -----------------------------------------------------------------------------------------*/
//      Click on "LOGIN" button with blank 'Email' and 'Password'
        common.clickAndWait(login.btnLogin);

//      VP1: 'Please fill out this field" message is displayed.
        System.out.print("VP1: 'Please fill out this field' message is displayed: ");
        login.checkMessage(errorMessage1, "validationMessage", login.txtEmail);

        /*-----------------------------------------------------------------------------------------
        VP2: 'The Email field must contain a valid email address' message is displayed
        -----------------------------------------------------------------------------------------*/
//      Click on "LOGIN" button with invalid format email and password. Ex: abc/123
        login.loginSuccessfully(true,baseUrl, invalidEmail1, invalidPass);

        Thread.sleep(5000);

//      VP2: 'The Email field must contain a valid email address' message is displayed
        System.out.print("VP2: 'The Email field must contain a valid email address' message is displayed: ");
        login.checkMessage(errorMessage2, "innerText", login.lblMessage);

         /*-----------------------------------------------------------------------------------------
        VP3: 'Invalid Login Credentials' message is displayed
        -----------------------------------------------------------------------------------------*/
//      Click on "LOGIN" button with invalid format email and password. Ex: admin1@phptravels.com/123
        login.loginSuccessfully(true,baseUrl, invalidEmail2, invalidPass);
        Thread.sleep(3000);

//      VP3: 'The Email field must contain a valid email address' message is displayed
        System.out.print("VP3: 'Invalid Login Credentials' message is displayed: ");
        login.checkMessage(errorMessage3, "innerText", login.lblMessage);

        System.out.println("End Test case: BE002-Login-Login to page unsuccessfully");

//      close Browser
        driver.close();
        driver.quit();
//        Thread.sleep(5000);
//        System.out.println(driver);
//        driver = null;
//        System.out.println(driver);
       /* ******************************************** END TEST CASE *********************************************
=======================================================================================================================*/
    }

}
