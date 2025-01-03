package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendLoginPage {
	
	
	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton; 
	
	
	@FindBy(xpath ="//a[text() = 'Sign up']")
	WebElement signupButton;
	
	
	

	
	
	
	public QALegendLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		pageutilities=new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
		
	}

	
	public void clickOnSignUp() {
		waitutility.waitForVisibilityofElement(signupButton);
		pageutilities.clickOnElement(signupButton);
	}



	public void login(String userName,String Password) {
		
		pageutilities.enterText(emailField, userName);
		pageutilities.enterText(passwordField, Password);
		pageutilities.clickOnElement(submitButton);
	}
	
	
	public String urlVerify() {
		
		String currenturl=pageutilities.getCurrentUrl();
		return currenturl;
		
	}
}
