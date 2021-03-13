package steps.com.products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.com.products.OrderPage;
import pages.com.products.ProductsLoginPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class ProductsSteps {

    WebDriver driver;
    ProductsLoginPage loginPage;
    OrderPage orderPage;

    @Given("the user navigates to product website home page")
    public void the_user_navigates_to_product_website_home_page() {
        driver= Driver.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        loginPage=new ProductsLoginPage(driver);
        loginPage.login(ConfigReader.getProperty("productsUsername"), ConfigReader.getProperty("productsPassword"));
    }

    @When("the user enters the product info {string} and {string}")
    public void the_user_enters_the_product_info_and(String productName, String quantity) {
       orderPage=new OrderPage(driver);
       orderPage.clickOrder();
       orderPage.sendProductInfo(productName,quantity);

    }

    @Then("the user enters the address info {string}, {string}, {string}, {string} , {string}")
    public void the_user_enters_the_address_info(String customerName, String street, String city, String state, String zip) {
        orderPage=new OrderPage(driver);
        orderPage.sendAddressInfo(customerName,street,city,state,zip);
    }

    @Then("the user enters the card info {string}, {string}, {string}")
    public void the_user_enters_the_card_info(String cardType, String cardNum, String expireDate) {
        orderPage=new OrderPage(driver);
        orderPage.sendPaymentInfo(cardType,cardNum,expireDate);
        orderPage.clickProcess();
    }

    @Then("user validates the success message")
    public void user_validates_the_success_message() throws InterruptedException {
        String actualMessage=orderPage.getMessageText();
        Assert.assertEquals("New order has been successfully added.",actualMessage);
    }


    @Then("the user validates product details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_validates_product_details(String productName, String quantity, String name, String street, String city, String state, String zipcode, String cardType, String cardNumber, String expireDate) {
        orderPage.clickViewOrder();
        List<WebElement> details=orderPage.productInfo;

        Assert.assertEquals(details.get(1).getText(),name);
        Assert.assertEquals(details.get(2).getText(),productName);
        Assert.assertEquals(details.get(3).getText(),quantity);
        Assert.assertEquals(details.get(5).getText(),street);
        Assert.assertEquals(details.get(6).getText(),city);
        Assert.assertEquals(details.get(7).getText(),state);
        Assert.assertEquals(details.get(8).getText(),zipcode);
        Assert.assertEquals(details.get(9).getText().replace(" ", "").toLowerCase(),cardType.replace(" ","").toLowerCase());
        Assert.assertEquals(details.get(10).getText(),cardNumber);
        Assert.assertEquals(details.get(11).getText(),expireDate);
    }
}