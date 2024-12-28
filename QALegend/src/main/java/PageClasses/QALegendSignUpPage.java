package PageClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendSignUpPage {
	
	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;


	@FindBy(xpath="//h2[text()='Sign up']")
	WebElement signUpLabel;
	@FindBy(id="first_name")
	WebElement firstnameTextBox;
	@FindBy(id="last_name")
	WebElement lastnameTextBox;
	@FindBy(id="company_name")
	WebElement companynameTextBox;
	@FindBy(id="email")
	WebElement emailTextBox;
	@FindBy(id="password")
	WebElement passwordTextBox;
	@FindBy(xpath = "//input[@name='retype_password']")
	WebElement retypepasswordTextBox;
	@FindBy(xpath="//input[@name='gender' and @value='male']")
	WebElement radiobuttonMale;
	@FindBy(xpath="//button[@type='submit']")
	WebElement signupButton;
	
	@FindBy(xpath="//div[@class='app-alert-message']")
	WebElement alertMessage;
	
	
	
	
	
	
	
	
	
	public QALegendSignUpPage(WebDriver driver) {
		
		this.driver=driver;
		pageutilities= new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	
	public void enterSignupDetails(String firstname,String lastname,String Company,String email,String password) {
		
		waitutility.waitForVisibilityofElement(signUpLabel);
		waitutility.waitForVisibilityofElement(firstnameTextBox);
		firstnameTextBox.sendKeys(firstname);
		lastnameTextBox.sendKeys(lastname);
		companynameTextBox.sendKeys(Company);
		emailTextBox.sendKeys(email);
		pageutilities.keyBoardTab();
		pageutilities.javascriptScrollBottom();
		waitutility.waitForVisibilityofElement(passwordTextBox);
		passwordTextBox.sendKeys(password);
		pageutilities.keyBoardTab();
		retypepasswordTextBox.sendKeys(password);
		pageutilities.clickOnElement(radiobuttonMale);
		pageutilities.clickOnElement(signupButton);
				
		
		
	}
	
	
	public String getAlertDetails() {
		
		
		pageutilities.javascriptScrollelementToView(alertMessage);
		String text =pageutilities.getTextOfElement(alertMessage);
		return text;
	}

}
