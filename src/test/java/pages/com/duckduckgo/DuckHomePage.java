package pages.com.duckduckgo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DuckHomePage {

    // Go to the DuckDuckGo website search Selenium
    // and validate search results contains Selenium keywords


    public DuckHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "search_form_input_homepage")
    public WebElement searchField;

    @FindBy(id="search_button_homepage")
    public WebElement searchButton;
}
