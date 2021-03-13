package pages.com.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsyHomePage {

    public EtsyHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchField;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;

    public void sendSearchKey(String searchValue){
        searchField.sendKeys(searchValue);
        searchButton.click();
    }
}
