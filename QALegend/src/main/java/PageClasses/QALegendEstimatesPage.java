package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendEstimatesPage {

	public WebDriver driver;
	public PageUtilities pageutilities;
	
	
	@FindBy(xpath = "//a[@title=\"Request an estimate\"]")
	WebElement requestanEstimateButton;
	@FindBy(xpath = "//a[text()=\"TestEstimate-Sample\"]")
	WebElement testEstimateOption;
	@FindBy(id = "custom_field_2")
	WebElement fieldTextBox;
	@FindBy(id = "s2id_autogen1")
	WebElement ageBox;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement requestEstimateButton;
	@FindBy(xpath= "//div[text()=\"Your request has been submitted successfully!\"]")
	WebElement alertMessage;
	
	
	
	
	
	public QALegendEstimatesPage(WebDriver driver) {
		
		this.driver= driver;
		pageutilities= new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	public void creatinganEstimate(String field) {
		
		pageutilities.waitForVisibility(requestanEstimateButton);
		pageutilities.clickOnElement(requestanEstimateButton);
		pageutilities.waitForVisibility(testEstimateOption);
		pageutilities.clickOnElement(testEstimateOption);
		pageutilities.enterText(fieldTextBox, field);
		pageutilities.clickOnElement(ageBox);
		pageutilities.keyBoardEnter();
		pageutilities.clickOnElement(requestEstimateButton);
		
		
	}
	
	public String createEstimateAlertValidation() {
		
		pageutilities.waitForVisibility(alertMessage);
		String message = pageutilities.getTextOfElement(alertMessage);
		return message;
	}
	
	
	
	

}
