package pages.com.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GroupOrderPage {

    public GroupOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="InviteNote")
    public WebElement inviteNote;

    @FindBy(name="InviteList")
    public WebElement invitelist;

    @FindBy(id = "createGroupOrder")
    public WebElement createGroupOrder;

    @FindBy(xpath = "//h1")
    public WebElement viewGroupOrderHeader;

    @FindBy(xpath = "//label[.='Total Participants:']/following-sibling::div")
    public WebElement totalParticipants;

    public void sendInviteeNote(String note){
        inviteNote.sendKeys(note);
    }


    public void sendInvitelist(String list){
        invitelist.sendKeys(list);
    }
    

    public void clickCreateGroup(){
        createGroupOrder.click();
    }

    public int getParticipantNumber(){
        return Integer.parseInt(totalParticipants.getText().trim());

    }
}
