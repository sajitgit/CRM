package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendLoginPage {
	
	
	public WebDriver driver;
	public PageUtilities pageutilities;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitButton; 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QALegendLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}








	public void login(String userName,String Password) {
		
		pageutilities.enterText(emailField, userName);
		pageutilities.enterText(passwordField, Password);
		pageutilities.clickOnElement(submitButton);
	}
}
