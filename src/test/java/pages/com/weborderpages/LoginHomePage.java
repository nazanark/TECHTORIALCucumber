package pages.com.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginHomePage {

    public LoginHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    public WebElement usernameField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    public void login(String username, String password){
        this.usernameField.clear();
        this.usernameField.sendKeys(username);
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
        this.signInButton.click();
    }
}
