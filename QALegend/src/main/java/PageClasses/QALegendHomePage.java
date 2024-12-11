package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendHomePage {

	
	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;
	
	
	@FindBy(xpath = "//span[text()=\"Events\"]")
	WebElement homepageEventButton;
	
	@FindBy(xpath = "//span[text()=\"Estimates\"]")
	WebElement homapageEstimatesButton;
	
	@FindBy(xpath = "//span[@class=\"topbar-user-name\"]")
	WebElement usernameText;
	
	@FindBy(xpath = "//i[@class=\"fa fa-desktop\"]")
	WebElement dashboarddropbutton;
	
	@FindBy(xpath = "(//div[@id=\"js-dashboard-popup-list\"]/a)[2]")
	WebElement dashboardplusButton;
	
	@FindBy(id = "title")
	WebElement createdashboardTitle;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement saveButton;
	
	@FindBy(id = "add-column-button")
	WebElement addRowButton;
	
	@FindBy(xpath="(//div[@class=\"grid-bg\"])[1]")
	WebElement gridPattern;
	
	@FindBy(xpath="//div[@data-value=\"total_projects\"]")
	WebElement totalProjectWidgetLeftColumn;
	
	@FindBy(xpath = "//span[text()=\"Drag and drop widgets here\"]")
	WebElement dropWidgetsArea;
	
	@FindBy(id = "save-and-show-button")
	WebElement saveAndShowbutton;
	
	@FindBy(xpath = "//div[@class=\"widget-details\"]//h1")
	WebElement projectcountinsideWidget;
	
	@FindBy(xpath = "//div[@class=\"js-dashboard-list\"]//a")
	List<WebElement> dropdownitemsdashboard;
	
	@FindBy(xpath = "//i[@class=\"fa fa-ellipsis-h\"]")
	WebElement ellipsisButton;
	
	@FindBy(id = "dashboard-edit-title-button")
	WebElement editbuttoninsideEllipsis;
	
	@FindBy(xpath="//h4[@class=\"pull-left\"]")
	WebElement titleinsideDashboardView;
	
	@FindBy(xpath = "//a[@class=\"delete\"]")
	WebElement deleteButtoninsideEllipsis;
	
	@FindBy(id = "confirmDeleteButton")
	WebElement confirmDeleteButton;
	
	
	
	
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		pageutilities=new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}


	public void clickOnHomePageEventButton() {
		
		homepageEventButton.click();
		
	}
	
	public String getUsernameText() {
		
		pageutilities.waitForVisibility(usernameText);
		String userName=pageutilities.getTextOfElement(usernameText);
		return userName;
		
	}
	
	public void creatingnewDashboard() {
		
		pageutilities.waitForVisibility(dashboarddropbutton);
		pageutilities.clickOnElement(dashboarddropbutton);
		waitutility.waitForVisibilityofElement(dashboardplusButton);
		pageutilities.clickOnElement(dashboardplusButton);
		pageutilities.enterText(createdashboardTitle, "Title");
		pageutilities.clickOnElement(saveButton);
		pageutilities.clickOnElement(addRowButton);
		pageutilities.clickOnElement(gridPattern);
		waitutility.waitForVisibilityofElement(dropWidgetsArea);
		pageutilities.clickOnElement(totalProjectWidgetLeftColumn);
		pageutilities.dragandDrop(totalProjectWidgetLeftColumn, dropWidgetsArea);
		pageutilities.clickOnElement(saveAndShowbutton);
		
		
	}
	
	public String totalProjectsCountfromwidgets() {
		pageutilities.waitForVisibility(projectcountinsideWidget);
		String count=pageutilities.getTextOfElement(projectcountinsideWidget);
		return count;
		
	}
	
	
	public void editingDashboard(String uniqueid) {
		
		pageutilities.waitForVisibility(dashboarddropbutton);
		pageutilities.clickOnElement(dashboarddropbutton);
		dropdownitemsdashboard.get(0).click();
		pageutilities.waitForVisibility(ellipsisButton);
		pageutilities.clickOnElement(ellipsisButton);
		pageutilities.clickOnElement(editbuttoninsideEllipsis);
		pageutilities.clearField(createdashboardTitle);
		pageutilities.enterText(createdashboardTitle, uniqueid);
		pageutilities.clickOnElement(saveButton);
		pageutilities.waitForInvisibility(saveButton);
		
	
		
	}
	
	public String validatatingEditDashboard() {
		
		pageutilities.waitForVisibility(projectcountinsideWidget);
		String title=pageutilities.getTextOfElement(titleinsideDashboardView);
		return title;		
		
	}
	
	
	public void deletingDashboard() {
		
		pageutilities.clickOnElement(ellipsisButton);
		pageutilities.clickOnElement(deleteButtoninsideEllipsis);
		pageutilities.clickOnElement(confirmDeleteButton);
			
		
	}
	
	public void clickOnEstimatesButton() {
		
		
		pageutilities.clickOnElement(homapageEstimatesButton);
	}
	

	
	
}
