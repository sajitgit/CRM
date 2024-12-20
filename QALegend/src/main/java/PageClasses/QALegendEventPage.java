package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendEventPage {
	

	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;
	
	@FindBy (xpath="(//a[@title='Add event'])[2]")
	WebElement addEventButton;	
	@FindBy(id="title")
	WebElement titleTextBox;	
	@FindBy(id="description")
	WebElement descriptionBox;
	@FindBy(id ="start_date")
	WebElement startdateBox;
	@FindBy(id="start_time")
	WebElement startTime;
	@FindBy(id="end_date")
	WebElement enddateBox;
	@FindBy(id="end_time")
	WebElement endTime;
	@FindBy(id="location")
	WebElement location;
	@FindBy(id="s2id_event_labels")
	WebElement labelBox;
	@FindBy(xpath="(//span[@class='select2-chosen'])[1]")
	WebElement clientBox;
	@FindBy(id="only_me")
	WebElement onlyMe;
	@FindBy(id="event_recurring")
	WebElement repeatCheckBox;
	@FindBy(id="repeat_every")
	WebElement repeatEvery;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	
	
	
	
	
		public QALegendEventPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		pageutilities= new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
		
		
		public void clickOnAddEventButton() {
			
			pageutilities.clickOnElement(addEventButton);
			
		}
	
	
	
		public void eventDetails(String title,String description) {
		
		
		titleTextBox.sendKeys(title);
		pageutilities.enterText(descriptionBox, description);
		startdateBox.sendKeys("2024-12-30");
		enddateBox.sendKeys("2025-1-28");
		//pageutilities.clickOnElement(saveButton);
		
		}
		
		
		public boolean eventPageSaveButtonStatusChecker() {
			
			return pageutilities.isElementEnabled(saveButton);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
