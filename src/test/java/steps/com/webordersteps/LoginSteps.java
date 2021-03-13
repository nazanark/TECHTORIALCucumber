package steps.com.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.com.weborderpages.LoginHomePage;
import utils.ConfigReader;
import utils.Driver;

public class LoginSteps {

    WebDriver driver;
    LoginHomePage loginHomePage;

    @Given("the user navigates to the WeobOrder")
    public void the_user_navigates_to_the_weob_order() {
        driver= Driver.getDriver();
        driver.navigate().to(ConfigReader.getProperty("webOrderUrl"));
    }

    @When("the user provides the credentials")
    public void the_user_provides_the_credentials() {
        loginHomePage=new LoginHomePage(driver);
        loginHomePage.login(ConfigReader.getProperty("webOrderUsername"),ConfigReader.getProperty("webOrderPassword"));
    }
    @Then("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        String expectedTitle = "ORDER DETAILS - Weborder";
        Assert.assertEquals("Home Page Validation after Login",expectedTitle,driver.getTitle());
    }
}
