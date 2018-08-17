package pageobjects.FE;

import support.CommonAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FEBasicInformationVisaPage {
    @FindBy(xpath = "//input[@data-ivisa-name='email']")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@data-ivisa-name='phone']")
    public WebElement txtPhone;

    @FindBy(xpath = "//div[@class='selected-dial-code']")
    public WebElement btnDialCode;

    @FindBy(xpath = "//ul[contains(@class,'country-list')]")
    public WebElement ddlDialCode;

    @FindBy(xpath = "//input[@data-ivisa-name='arrival_date']")
    public WebElement btnArrivalDate;

    @FindBy(xpath = "//table[contains(@class, 'table-condensed')]//td[contains(@class, 'active')]")
    public WebElement tblToday;

    @FindBy(xpath = "//input[@data-ivisa-name='address']")
    public WebElement txtHomeAddress;

    @FindBy(xpath = "//select[@data-ivisa-name='home_country']")
    public WebElement ddlHomeCountry;

    @FindBy(xpath = "//select[@data-ivisa-name='traveling_by']")
    public WebElement ddlTravelBy;

    @FindBy(xpath = "//section[@style='display: block;']//input[@data-ivisa-name='first_name']")
    public WebElement txtFirstMiddleName;

    @FindBy(xpath = "//section[@style='display: block;']//input[@data-ivisa-name='last_name']")
    public WebElement txtLastName;

    @FindBy(xpath = "//section[@style='display: block;']//select[@data-ivisa-name='nationality_country']")
    public WebElement ddlNationality;

    @FindBy(xpath = "//section[@style='display: block;']//input[@data-ivisa-name='dob']")
    public WebElement btnBirthday;

    @FindBy(xpath = "//section[@style='display: block;']//select[@data-ivisa-name='gender']")
    public WebElement ddlGender;

    @FindBy(xpath = "//section[@style='display: block;']//input[@data-ivisa-name='passport_num']")
    public WebElement txtPassport;

    @FindBy(xpath = "//section[@style='display: block;']//input[@data-ivisa-name='passport_issued_date']")
    public WebElement btnPassportIssued;

    @FindBy(xpath = "//section[@style='display: block;']//input[@data-ivisa-name='passport_expiration_date']")
    public WebElement btnPassportExpiration;

    @FindBy(xpath = "//button[.='Next']")
    public WebElement btnNext;

    @FindBy(xpath = "//select[@id='dp_month']")
    public WebElement ddlMonth;

    @FindBy(xpath = "//select[@id='dp_day']")
    public WebElement ddlDay;

    @FindBy(xpath = "//select[@id='dp_year']")
    public WebElement ddlYear;

    @FindBy(xpath = "(//select[@data-ivisa-name='visa_type'])[2]")
    public WebElement ddlVisaType;

    @FindBy(xpath = "//button[@id='dp_save']")
    public WebElement btnSave;

    public FEBasicInformationVisaPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void chooseDate(String date){
        CommonAction common = new CommonAction();
        common.waitForElementVisible(ddlMonth);
        String [] arrayDate = date.split("-");
        common.clickAndWait(ddlMonth);
        common.selectOptionByValue(ddlMonth, arrayDate[1]);
        common.clickAndWait(ddlDay);
        common.selectOptionByValue(ddlDay, arrayDate[2]);
        common.clickAndWait(ddlYear);
        common.selectOptionByText(ddlYear, arrayDate[0]);
        common.clickAndWait(btnSave);
        common.waitForElementVisible(btnPassportExpiration);
    }
}
