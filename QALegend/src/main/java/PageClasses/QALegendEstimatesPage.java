package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendEstimatesPage {

	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;
	
	
	@FindBy(xpath = "//a[@title='Request an estimate']")
	WebElement requestanEstimateButton;
	@FindBy(xpath = "//a[text()='TestEstimate-Sample']")
	WebElement testEstimateOption;
	@FindBy(id = "custom_field_2")
	WebElement fieldTextBox;
	@FindBy(id = "s2id_autogen1")
	WebElement ageBox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement requestEstimateButton;
	@FindBy(xpath= "//div[text()='Your request has been submitted successfully!']")
	WebElement alertMessage;
	@FindBy(xpath="//li[@class='list-group-item']/a")
	List<WebElement> estimateList;
	
	
	
	
	
	public QALegendEstimatesPage(WebDriver driver) {
		
		this.driver= driver;
		pageutilities= new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	public void creatinganEstimate(String field) {
		
		waitutility.waitForVisibilityofElement(requestanEstimateButton);
		pageutilities.clickOnElement(requestanEstimateButton);
		
		for(int i=0;i<estimateList.size();i++) {
			
			String text = estimateList.get(i).getText();
			if(text.contains("TestEstimate-Sample")) {
				estimateList.get(i).click();
				break;
			}
		}
		
		pageutilities.enterText(fieldTextBox, field);
		pageutilities.clickOnElement(ageBox);
		pageutilities.keyBoardEnter();
		pageutilities.clickOnElement(requestEstimateButton);	
		
		
	}
	
	
	public String createEstimateAlertValidation() {
		
		waitutility.waitForVisibilityofElement(alertMessage);
		String message = pageutilities.getTextOfElement(alertMessage);
		return message;
	}
	
	
	
	

}
