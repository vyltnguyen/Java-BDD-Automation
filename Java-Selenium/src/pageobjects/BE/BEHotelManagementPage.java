package pageobjects.BE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BEHotelManagementPage {
    @FindBy(xpath = "//ul[@id='social-sidebar-menu']")
    public WebElement mnuMain;

    @FindBy(xpath = "//form[@class='add_button']//button")
    public WebElement btnAdd;

    @FindBy(xpath = "//div[@class = 'xcrud-list-container']/table")
    public WebElement tblHotelResults;

    public BEHotelManagementPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
