package pages.com.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ConfirmAddressID")
    public WebElement deliveryOptions;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    public WebElement groupOrderCheckbox;

    @FindBy(id="getAddressNextButton")
    public WebElement nextButton;
}
