package steps.com.webordersteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.com.weborderpages.GroupOrderPage;
import pages.com.weborderpages.HomePage;
import pages.com.weborderpages.LoginHomePage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class NewGroupSteps {

    WebDriver driver;
    LoginHomePage loginHomePage;
    HomePage homePage;
    GroupOrderPage groupOrderPage;

    @Given("the user is on weborder home page")
    public void the_user_is_on_weborder_home_page() {
        driver= Driver.getDriver();
        driver.get(ConfigReader.getProperty("webOrderUrl"));
        loginHomePage=new LoginHomePage(driver);
        loginHomePage.login(ConfigReader.getProperty("webOrderUsername"), ConfigReader.getProperty("webOrderPassword"));

    }
    @When("the user selects {string} option")
    public void the_user_selects_option(String text) {
        homePage=new HomePage(driver);
        BrowserUtils.selectText(homePage.deliveryOptions,text);
    }
    @Then("the user is on the group order page")
    public void the_user_is_on_the_group_order_page() {
        homePage=new HomePage(driver);
        homePage.groupOrderCheckbox.click();
        homePage.nextButton.click();
    }

    @When("the user send invitees note {string}")
    public void the_user_send_initees_note(String note) {
        groupOrderPage=new GroupOrderPage(driver);
        groupOrderPage.sendInviteeNote(note);
    }
    @Then("the user send invite list {string} and {string}")
    public void the_user_send_invite_list_and(String email1, String email2) {
        groupOrderPage=new GroupOrderPage(driver);
        groupOrderPage.sendInvitelist(email1+","+email2);
        groupOrderPage.clickCreateGroup();
    }
    @Then("the user validate {string} text")
    public void the_user_validate_text(String expectedText) throws InterruptedException {
        Thread.sleep(300);
        String actualText=groupOrderPage.viewGroupOrderHeader.getText();
        Assert.assertEquals(actualText,expectedText);
    }

    @Then("the user validate total participant is {int}")
    public void the_user_validate_total_participant_is(Integer expectedNum) {
        groupOrderPage=new GroupOrderPage(driver);
        Integer participantNumber=groupOrderPage.getParticipantNumber();
        Assert.assertEquals(participantNumber,expectedNum);
    }

}
