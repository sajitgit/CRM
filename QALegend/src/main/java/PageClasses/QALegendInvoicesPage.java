package PageClasses;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendInvoicesPage {
	
	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;
	public float sum;
	public boolean projectdisplayed = false;

	@FindBy(xpath = "//table[@id=\"invoice-table\"]//tbody//td[5]")
	List<WebElement> invoicesValueColumn;
	@FindBy(xpath = "//th[text()=\"Total\"]//following-sibling::th[1]")
	WebElement totalAmount;
	@FindBy(xpath = "//i[@class=\"fa fa-eye-slash\"]")
	WebElement eyeButton;
	@FindBy(xpath = "//div[@class=\"popover-content\"]//li")
	List<WebElement> eyeButtonDropdownList; 
	@FindBy(xpath="//table[@id=\"invoice-table\"]//thead//tr//th")
	List<WebElement> coloumnTitles;
	
	
	
	
		

	
	public QALegendInvoicesPage(WebDriver driver) {
		
		this.driver=driver;
		pageutilities = new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public float checkingInvoiceAmount() {
		
		waitutility.waitForVisibilityofAllElements(invoicesValueColumn);
		
			for(int i =0;i<invoicesValueColumn.size();i++) {
			String price = invoicesValueColumn.get(i).getText().replace("$", "");
			float convertedtofloatprice = Float.parseFloat(price);
			float array[] = new float[invoicesValueColumn.size()];
			array[i]=convertedtofloatprice;
			
				for(int j=0;j<invoicesValueColumn.size();j++) {
					
					sum = sum+array[j];
				}
			
			}
			return sum;
}
	
	public float checkingTotal() {
		
		String total = pageutilities.getTextOfElement(totalAmount).replace("$", "");
		float floatvaluetotal = Float.parseFloat(total);
		return floatvaluetotal;
		
	}
	
	public void eyebutton() {
		
		waitutility.waitForVisibilityofAllElements(invoicesValueColumn);
		pageutilities.clickOnElement(eyeButton);
		for(int i=0;i<eyeButtonDropdownList.size();i++) {
			String menu = eyeButtonDropdownList.get(i).getText();
			if(menu.equalsIgnoreCase("Project")) {
				eyeButtonDropdownList.get(i).click();
			}
		}
		
		pageutilities.clickOnElement(eyeButton);
		
		
	}
	
	
	public boolean eyebuttonFunctionality() {
		
		List<String> titles = new ArrayList<String>();
		waitutility.waitForInvisibilityofAllElements(eyeButtonDropdownList);
		for(int i =0;i<coloumnTitles.size();i++) {
			
			String coloumnname = coloumnTitles.get(i).getText();
			
			titles.add(coloumnname);
	
			}
		for(int j=0;j<titles.size();j++) {
			
			
			if(titles.contains("Project")) {
				
				 projectdisplayed=true;
				
			}
		
	}
		
		return projectdisplayed;
}
	
}
