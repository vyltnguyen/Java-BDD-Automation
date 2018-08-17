package pageobjects.BE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BEAddNewHotelPage {
    @FindBy(xpath = "//input[@name='hotelname']")
    public WebElement txtHotelName;

    @FindBy(xpath = "//div[@id='cke_1_contents']//iframe")
    public WebElement iframeDescription;

    @FindBy(xpath = "//body[contains(@class, 'cke_contents_ltr')]")
    public WebElement txtDescription;

    @FindBy(xpath = "//input[@name='ffrom']")
    public WebElement txtFromFeature;

    @FindBy(xpath = "//input[@name='fto']")
    public WebElement txtToFeature;

    @FindBy(xpath = "//div[@id ='s2id_searching']//span[.='Enter Location']")
    public WebElement btnLocation;
    //
    @FindBy(xpath = "//div[@class='select2-search']//input")
    public WebElement txtLocation;

    @FindBy(xpath = "//div[@class = 'select2-result-label']")
    public WebElement btnLocationResults;

    @FindBy(xpath = "//button[@id = 'add' and .='Submit']")
    public WebElement btnSubmit;

    public BEAddNewHotelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
