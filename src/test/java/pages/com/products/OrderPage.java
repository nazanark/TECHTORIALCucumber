package pages.com.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class OrderPage {

    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='Order']")
    public WebElement orderButton;

    public void clickOrder(){
        orderButton.click();
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productName;

    public void selectByText(String text){
        BrowserUtils.selectText(productName, text);
    }


    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;


    public void sendQuantity(String quantityNum){
        quantity.sendKeys(quantityNum);
    }

    public void sendProductInfo(String productName, String quantity){
        selectByText(productName);
        sendQuantity(quantity);
    }


    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameField;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipField;

    public void sendAddressInfo(String customerName, String street, String city, String state, String zipcode){
        customerNameField.sendKeys(customerName);
        streetField.sendKeys(street);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipField.sendKeys(zipcode);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadio;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement masterCardRadio;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement americanExpressRadio;

        public void selectCard(String cardType) {
            cardType = cardType.toLowerCase();

            switch (cardType) {
                case "visa":
                    visaRadio.click();
                    break;

                case "master card":
                    masterCardRadio.click();
                    break;

                case "american express":
                    americanExpressRadio.click();
                    break;

                default:
                    System.out.println("Card name is not correct. Please change card name");
                    break;
            }
    }


    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    public void sendPaymentInfo(String cardType,String cardNumber, String expireDate){
        selectCard(cardType);
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    public void clickProcess(){
        processButton.click();
    }

    @FindBy(xpath = "//div[@class='buttons_process']/a/following-sibling::strong")
    public WebElement text;

    public String getMessageText(){
        return text.getText();
    }

    @FindBy(linkText = "View all orders")
    public WebElement allOrdersButton;

    public void clickViewOrder(){
        allOrdersButton.click();
    }

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]/td")
    public List<WebElement> productInfo;

}
