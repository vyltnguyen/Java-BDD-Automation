package testcase;

import support.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.BEAddNewHotelPage;
import pageobjects.BEHotelManagementPage;
import pageobjects.BELoginPage;
import support.Driver;

public class BE004CreateNewHotelSuccessfully {
    private String validEmail = "admin@phptravels.com";
    private String validPass = "demoadmin";
    private String mnuHotelsName ="Hotels ";
    private String subHotelsName = "Hotels";
    private String fromFeature = "01/08/2018";
    private String toFeature = "31/08/2018";
    private String location = "Vung Tau";
    private String baseUrl = "https://www.phptravels.net/admin";
    private String hotelName = "Hotel 1";
    private WebDriver driver = Driver.DriverChrome();

    public void createHotel() throws InterruptedException {
        /*=====================================================================================================================
         **************Start Test case: BE002-Login-Login to page unsuccessfully**********************/
        System.out.println("Start Test case: BE004-Hotels-Create a new hotel successful");

        /*-----------------------------------------------------------------------------------------
        VP1: The Created Hotel displays on Hotel Management with correct information
        -----------------------------------------------------------------------------------------*/
//        Define page object
        BEHotelManagementPage hotelManagementPage = new BEHotelManagementPage(driver);
        BEAddNewHotelPage addNewHotelPage = new BEAddNewHotelPage(driver);
        BELoginPage loginPage = new BELoginPage(driver);

//        Login to page
        loginPage.loginSuccessfully(false, baseUrl, validEmail, validPass);

//        Navigate to Hotels Management page
        CommonAction common = new CommonAction();
        common.goToFunc(hotelManagementPage.mnuMain, mnuHotelsName, subHotelsName);

//        Click on Add button
        common.clickAndWait(hotelManagementPage.btnAdd);
//        Input all Hotel Information on General tab
        common.setText(addNewHotelPage.txtHotelName, hotelName);
        common.setText(addNewHotelPage.iframeDescription, addNewHotelPage.txtDescription, hotelName);
        common.setText(addNewHotelPage.txtFromFeature, fromFeature);
        common.setText(addNewHotelPage.txtToFeature, toFeature);
        common.clickAndWait(addNewHotelPage.btnLocation);
        common.setText(addNewHotelPage.txtLocation, location);
        common.clickAndWait(addNewHotelPage.btnLocationResults.findElement(By.xpath("//span[.='" + location + "']")));
        common.clickAndWait(addNewHotelPage.btnSubmit);

//        VP1: The Created Hotel displays on Hotel Management with correct information
        System.out.print("VP1: The Created Hotel displays on Hotel Management with correct information: ");
        if (hotelManagementPage.tblHotelResults.findElement(By.xpath("//tr[.//td[.='" + hotelName + "']]")).isDisplayed())
            System.out.println("Test Passed!");
        else
            System.out.println("Test Failed!");
        System.out.println("End Test case: BE004-Hotels-Create a new hotel successful");

//      close Browser
        driver.close();
        driver.quit();

        driver = null;
       /* ******************************************** END TEST CASE *********************************************
=======================================================================================================================*/
    }
}
