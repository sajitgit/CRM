package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendMessagesPage {
	
	
	public WebDriver driver;
	public PageUtilities pageutility;
	public WaitUtility waitutility;
	
	@FindBy(xpath = "//ul[@class='list-group ']//a")
	List<WebElement> featuresInboxList;	
	@FindBy(id = "s2id_to_user_id")
	WebElement toDropdownBox;
	@FindBy(id = "s2id_autogen3_search")
	WebElement toSearchBox;
	@FindBy(id = "subject")
	WebElement subjectBox;
	@FindBy (id = "message")
	WebElement messageArea;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;
	@FindBy(id = "search-messages")
	WebElement searchMessages;
	@FindBy(xpath = "(//div[@class='media-heading'])[1]")
	WebElement sentTextFirstListItem;
	@FindBy(xpath = "//div[@class='media-heading clearfix']//following::span//following::p[2]")
	WebElement senttext;
	@FindBy(xpath="//div[@class='circle-loader']")
	WebElement loader;
	
	
	
	
	
	public QALegendMessagesPage(WebDriver driver) {
		this.driver = driver;
		pageutility = new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void composeMessage(String username,String messageText) {
		
		waitutility.waitForVisibilityofAllElements(featuresInboxList);
		featuresInboxList.get(0).click();
		waitutility.waitForVisibilityofElement(toDropdownBox);
		pageutility.clickOnElement(toDropdownBox);
		pageutility.enterText(toSearchBox, username);
		pageutility.keyBoardEnter();
		pageutility.enterText(subjectBox, messageText);
		pageutility.enterText(messageArea, messageText);
		pageutility.clickOnElement(sendButton);
		waitutility.waitForInvisibilityofElement(loader);
		
		
	}
	
	
	public String validatingMessageSent(String username) {
		
		featuresInboxList.get(2).click();
		waitutility.waitForVisibilityofElement(searchMessages);
		pageutility.enterText(searchMessages, username);
		pageutility.keyBoardEnter();
		pageutility.clickOnElement(sentTextFirstListItem);
		String messageFromSentItems =pageutility.getTextOfElement(senttext);
		return messageFromSentItems;
		
	}
	
	
	

}
