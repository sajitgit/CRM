package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomePage {

	
	public WebDriver driver;
	public PageUtilities pageutilities;
	
	
	@FindBy(xpath = "//span[text()=\"Events\"]")
	WebElement homepageEventButton;
	
	
	
	
	
	
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}







	public void clickOnHomePageEventButton() {
		
		homepageEventButton.click();
		
	}
	
	
}
