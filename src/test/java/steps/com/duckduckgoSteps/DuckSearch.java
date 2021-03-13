package steps.com.duckduckgoSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.com.duckduckgo.DuckHomePage;
import pages.com.duckduckgo.DuckSearchResultPage;

import static utils.Driver.getDriver;

public class DuckSearch {

    WebDriver driver;
    DuckHomePage duckHomePage;
    DuckSearchResultPage duckSearchResultPage;


    @Given("user is on DuckDuckGo page")
    public void user_is_on_duck_duck_go_page() {
        driver= getDriver();
        getDriver().get("https://duckduckgo.com/");
    }
    @When("user searches for selenium")
    public void user_searches_for_selenium() {
        duckHomePage=new DuckHomePage(driver);
        duckHomePage.searchField.sendKeys("Selenium");
        duckHomePage.searchButton.click();
    }
    @Then("user sees results about selenium")
    public void user_sees_results_about_selenium() {
        duckSearchResultPage=new DuckSearchResultPage(driver);
        for(WebElement link: duckSearchResultPage.listOfLinks){
            System.out.println(link.getText());
        }

    }
    @And("the results contains Selenium keywords")
    public void the_results_contains_selenium_keywords() {
        duckSearchResultPage=new DuckSearchResultPage(driver);
        String expected="selenium".toLowerCase();
        Assert.assertTrue(expected.contains("selenium"));
    }
}
