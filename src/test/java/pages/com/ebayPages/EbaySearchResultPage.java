package pages.com.ebayPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbaySearchResultPage {

    public EbaySearchResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@class='s-item__title']")
    public List <WebElement> listOfLinks;

    @FindBy(xpath = "//div[@class='s-pagination']//li")
    public List <WebElement> pages;
}
