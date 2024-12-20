package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendTicketsPage {
	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;
	
	
	@FindBy(xpath = "//a[@title='Add ticket']")
	WebElement addticketButton;
	@FindBy(id = "title")
	WebElement titleTextBox;
	@FindBy(id = "description")
	WebElement descriptionTextBox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath="//input[@type='search']")
	WebElement ticketSearchBox;
	@FindBy(xpath="(//table[@id='ticket-table']//tbody//tr//a)[1]")
	WebElement bugIDLink;
	@FindBy(xpath = "//table[@id='ticket-table']//tr//td//span")
	List<WebElement> tablerownewStatus;
	@FindBy(xpath ="//table[@id='ticket-table']//tr//td//a")
	List<WebElement> tablerowid;
	@FindBy(xpath="//div[@class='circle-loader']")
	WebElement loader;
	@FindBy(xpath="//i[@class='fa fa-cogs']")
	WebElement optionsbutton;
	@FindBy(xpath="//a[@title='Mark Project as Open']")
	WebElement markasClosedButton;
	@FindBy(xpath ="//span[@class='label label-success large']")
	WebElement closedStatusLabel;
	
	
	
	public QALegendTicketsPage(WebDriver driver) {
		this.driver=driver;
		pageutilities=new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void creatingnewTicket(String title,String titledesc) {
		
		waitutility.waitForVisibilityofElement(addticketButton);
		pageutilities.clickOnElement(addticketButton);
		pageutilities.enterText(titleTextBox, title);
		pageutilities.enterText(descriptionTextBox, titledesc);
		pageutilities.clickOnElement(saveButton);
		
	}
	
	
	public void searchingBug(String bugTitle) {
		
		waitutility.waitForInvisibilityofElement(loader);
		waitutility.waitForVisibilityofElement(addticketButton);
		pageutilities.clickOnElement(ticketSearchBox);
		pageutilities.enterText(ticketSearchBox, bugTitle);
		pageutilities.keyBoardEnter();
				
	}
	
	
	public String validatingnewstatus() {
				
		String status = tablerownewStatus.get(0).getText();
		return status;
				
	}
	
	public void closingNewTicket() {
		
		
		pageutilities.clickOnElement(bugIDLink);
		waitutility.waitForVisibilityofElement(optionsbutton);
		pageutilities.clickOnElement(optionsbutton);
		waitutility.waitForVisibilityofElement(markasClosedButton);
		pageutilities.clickOnElement(markasClosedButton);
		waitutility.waitForInvisibilityofElement(loader);
			
		
	}
	
	public String validatingclosedStatus() {
		
		waitutility.waitForVisibilityofElement(closedStatusLabel);
		String status = closedStatusLabel.getText();
		return status;
	}
	
	
	
	
	

}
