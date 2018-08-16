package testcase;

import support.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageobjects.FEBasicInformationVisaPage;
import pageobjects.FERevisionAndPaymentPage;
import support.Driver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FE009VerifyRevisionAndPament {
    private String baseUrl = "https://www.phptravels.net/ivisa";
    private String validEmail = "user@phptravels.com";
    private String phoneNumber = "123456789";
    private String homeAddress = "Home Address";
    private String homeCountry = "Vietnam (VN)";
    private String travelBy = "Air";
    private String firstMiddle = "User";
    private String lastName = "User";
    private String nationality = "Austria (AT)";
    private String birthday = "1980-01-01";
    private String gender = "Female";
    private String passportNumber = "123456789";
    private String passportIssued = "2000-01-01";
    private String passportExpiration = "2020-01-01";
    private String dialCode = "+84";
    private WebDriver driver = Driver.DriverChrome();

    public void verifyRevisionAndPayment() throws InterruptedException {
        /*=====================================================================================================================
         **************Start Test case: BE002-Login-Login to page unsuccessfully**********************/
        System.out.println("Start Test case: BE004-Hotels-Create a new hotel successful");
        /*-----------------------------------------------------------------------------------------
        VP1: The Created Hotel displays on Hotel Management with correct information
        -----------------------------------------------------------------------------------------*/
//        Define page object
        FEBasicInformationVisaPage basicInformationVisaPage = new FEBasicInformationVisaPage(driver);
        FERevisionAndPaymentPage revisionAndPaymentPage = new FERevisionAndPaymentPage(driver);
//        Navigate to Hotels Management page
        CommonAction common = new CommonAction();
        common.navigateToUrl(baseUrl);

//        Input valid General information:
        common.setText(basicInformationVisaPage.txtEmail, validEmail);
        common.clickAndWait(basicInformationVisaPage.btnArrivalDate);
        common.clickAndWait(basicInformationVisaPage.tblToday);

        //Get Arrival date
        String arrivalDate = basicInformationVisaPage.btnArrivalDate.getAttribute("data-ivisa-min-date");

//        Input valid General information continue:
        common.clickAndWait(basicInformationVisaPage.btnDialCode);
        common.clickAndWait(basicInformationVisaPage.ddlDialCode.findElement(By.xpath("//li[.//span[.='" + dialCode + "']]")));
        common.setText(basicInformationVisaPage.txtPhone, phoneNumber);
        common.setText(basicInformationVisaPage.txtHomeAddress, homeAddress);
        common.clickAndWait(basicInformationVisaPage.ddlHomeCountry);
        common.selectOptionByText(basicInformationVisaPage.ddlHomeCountry, homeCountry);
        common.clickAndWait(basicInformationVisaPage.ddlTravelBy);
        common.selectOptionByText(basicInformationVisaPage.ddlTravelBy,travelBy);

//        Scroll to element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", basicInformationVisaPage.txtFirstMiddleName);

//        Input valid Applicant #1 information:
        basicInformationVisaPage.txtFirstMiddleName.click();
        common.setText(basicInformationVisaPage.txtFirstMiddleName, firstMiddle);
        common.setText(basicInformationVisaPage.txtLastName, lastName);
        common.selectOptionByText(basicInformationVisaPage.ddlNationality, nationality);
        common.clickAndWait(basicInformationVisaPage.btnBirthday);
        Thread.sleep(2000);
        basicInformationVisaPage.chooseDate(birthday);
        common.selectOptionByText(basicInformationVisaPage.ddlGender, gender);
        common.setText(basicInformationVisaPage.txtPassport, passportNumber);
        common.clickAndWait(basicInformationVisaPage.btnPassportIssued);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        basicInformationVisaPage.chooseDate(passportIssued);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        common.clickAndWait(basicInformationVisaPage.btnPassportExpiration);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        basicInformationVisaPage.chooseDate(passportExpiration);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        common.selectOptionByIndex(basicInformationVisaPage.ddlVisaType, 1);
        String visaType = basicInformationVisaPage.ddlVisaType.getAttribute("textContent"); //Get Visa Type

//        Scroll to element
        js.executeScript("arguments[0].scrollIntoView();", basicInformationVisaPage.btnNext);

        common.clickAndWait(basicInformationVisaPage.btnNext);
        ArrayList<String> result = new ArrayList<String>();

//        Verify Contact Information are displayed correctly like as information at step 2
        System.out.println("Verify Contact Information are displayed correctly like as information:");

        result.add(revisionAndPaymentPage.verifyValueOfContactInformation("Email address", validEmail));
        result.add(revisionAndPaymentPage.verifyValueOfContactInformation("Arrival Date in Canada",
                common.convertDate(arrivalDate,"yyyy-MM-dd", "MMM-dd-yyyy")));
        result.add(revisionAndPaymentPage.verifyValueOfContactInformation("Phone",
                dialCode + phoneNumber));
        result.add(revisionAndPaymentPage.verifyValueOfContactInformation(
                "Home Address (include city & ZIP code)", homeAddress));
        result.add(revisionAndPaymentPage.verifyValueOfContactInformation("Home Country", homeCountry));
        result.add(revisionAndPaymentPage.verifyValueOfContactInformation("Traveling By", travelBy));

//        Verify Application Information are displayed correctly like as information at step 3
        System.out.println("Verify Application Information are displayed correctly like as information:");
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(1,
                "First and Middle Name", firstMiddle));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(2,
                "Last Name", lastName));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(3,
                "Nationality (as in Passport)",
                nationality));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(4, "Birthday",
                common.convertDate(birthday,"yyyy-MM-dd", "MMM-d-yyyy")));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(5, "Gender", gender));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(6, "Passport Number",
                passportNumber));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(7, "Passport Issued",
                common.convertDate(passportIssued,"yyyy-MM-dd", "MMM-d-yyyy")));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(8, "Passport Expiration",
                common.convertDate(passportExpiration,"yyyy-MM-dd", "MMM-d-yyyy")));
        result.add(revisionAndPaymentPage.verifyValueOfApplicants(9, "Canada Visa Type",
                visaType.substring(1,visaType.length())));


        System.out.print("VP2: 'VP1: The Created Hotel displays on Hotel Management with correct information: ");
        boolean finalResult = true;
        for(int i = 0; i < result.size(); i++) {
            if (result.get(i).contentEquals("Test Failed!")) {
                finalResult = false;
                break;
            }
        }
        if (finalResult == true)  System.out.println("Test Passed!");
        else  System.out.println("Test Failed!");

        System.out.println("End Test case:BE004-Hotels-Create a new hotel successful");

//      close Browser
        driver.close();
        driver.quit();

        driver = null;
       /* ******************************************** END TEST CASE *********************************************
=======================================================================================================================*/
    }
}
