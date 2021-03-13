package steps.com.etsy;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.com.etsy.EtsyHomePage;
import utils.BrowserUtils;
import utils.Driver;

public class EtsySearchSteps {

    WebDriver driver;
    EtsyHomePage etsyHomePage;

    @Before
    public void beforeScenario(){
        // will run for each scenario
        System.out.println("Before annotation");
    }
    @Before("@tc2")
    public void conditionalHook(){
        System.out.println("Conditional annotation");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("Before Each Step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("After Each Step");
    }


    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
        // will run after each scenario
        System.out.println("After Annotation");
        if(scenario.isFailed()){
            BrowserUtils.takeScreenshot();
        }
    }


    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) {
       driver= Driver.getDriver();
       driver.navigate().to(url);
    }

    @When("the search with {string}")
    public void the_search_with(String searchValue) {
        etsyHomePage=new EtsyHomePage(driver);
        etsyHomePage.sendSearchKey(searchValue);
    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedTitle) {
        String actualTitle=driver.getTitle();
        Assert.assertEquals("Validation of title", expectedTitle, actualTitle);
    }
}
