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
	
	
	@FindBy(xpath = "//span[text()='Events']")
	WebElement homepageEventButton;
	
	@FindBy(xpath = "//span[text()='Estimates']")
	WebElement homapageEstimatesButton;
	
	@FindBy(xpath="//span[text()='Tickets']")
	WebElement homepageTicketsButton;
	
	@FindBy(xpath = "//span[text()='Invoices']")
	WebElement homepageInvoicesButton;
	
	@FindBy(xpath = "//span[text()='Messages']")
	WebElement homepageMessagesButton;
	
	@FindBy(id = "user-dropdown-icon")
	WebElement dropdownIcon;
	
	@FindBy(xpath = "//span[@class='topbar-user-name']")
	WebElement usernameText;
	
	@FindBy(xpath = "//i[@class='fa fa-desktop']")
	WebElement dashboarddropbutton;
	
	@FindBy(xpath = "(//div[@id='js-dashboard-popup-list']/a)[2]")
	WebElement dashboardplusButton;
	
	@FindBy(id = "title")
	WebElement createdashboardTitle;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(id = "add-column-button")
	WebElement addRowButton;
	
	@FindBy(id ="add-column-collapse-panel")
	WebElement coloumncollapsePanel;
	
	@FindBy(xpath="(//div[@class='grid-bg'])[1]")
	WebElement gridPattern;
	
	@FindBy(id="add-column-panel-1000000")
	WebElement coloumnpanel;
	
	@FindBy(xpath="//div[@data-value='total_projects']")
	WebElement totalProjectWidgetLeftColumn;
	
	@FindBy(xpath = "//div[@id='add-column-panel-1000000']//div//span")
	List<WebElement> columnOptionswidget;
	
	@FindBy(xpath = "//span[text()='Drag and drop widgets here']")
	WebElement dropWidgetsArea;
	
	@FindBy(id = "save-and-show-button")
	WebElement saveAndShowbutton;
	
	@FindBy(xpath = "//div[@class='widget-details']//h1")
	WebElement projectcountinsideWidget;
	
	@FindBy(xpath = "//div[@class='js-dashboard-list']//a")
	List<WebElement> dropdownitemsdashboard;
	
	@FindBy(xpath = "//i[@class='fa fa-ellipsis-h']")
	WebElement ellipsisButton;
	
	@FindBy(id = "dashboard-edit-title-button")
	WebElement editbuttoninsideEllipsis;
	
	@FindBy(xpath="//h4[@class='pull-left']")
	WebElement titleinsideDashboardView;
	
	@FindBy(xpath = "//a[@class='delete']")
	WebElement deleteButtoninsideEllipsis;
	
	@FindBy(id = "confirmDeleteButton")
	WebElement confirmDeleteButton;
	
	@FindBy(xpath="//div[@class='circle-loader']")
	WebElement loader;
	
	
	
	
	
	public QALegendHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		pageutilities=new PageUtilities(driver);
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}


	public QALegendHomePage clickOnHomePageEventButton() {
		
		homepageEventButton.click();
		return this;
		
	}
	
	public boolean usernameisDisplayedorNot() {
		
		waitutility.waitForInvisibilityofElement(loader);
		waitutility.waitForVisibilityofElement(usernameText);
		boolean status = pageutilities.isElementDisplayed(usernameText);
		return status;
		
	}
	
	public String getUsernameText() {
		
		waitutility.waitForInvisibilityofElement(loader);
		waitutility.waitForVisibilityofElement(dropdownIcon);
		String userName=pageutilities.getTextOfElement(usernameText);
		return userName;
		
	}
	
	public QALegendHomePage creatingnewDashboard() {
		
		waitutility.waitForVisibilityofElement(dashboarddropbutton);
		pageutilities.clickOnElement(dashboarddropbutton);
		waitutility.waitForVisibilityofElement(dashboardplusButton);
		pageutilities.clickOnElement(dashboardplusButton);
		waitutility.waitForVisibilityofElement(createdashboardTitle);
		pageutilities.enterText(createdashboardTitle, "Title");
		pageutilities.clickOnElement(saveButton);
		waitutility.waitForInvisibilityofElement(loader);
		pageutilities.clickOnElement(addRowButton);
		waitutility.waitForVisibilityofElement(coloumncollapsePanel);
		pageutilities.clickOnElement(gridPattern);
		waitutility.waitForVisibilityofAllElements(columnOptionswidget);
		waitutility.waitForVisibilityofElement(dropWidgetsArea);
		pageutilities.mouseLongPress(columnOptionswidget.get(0));
		pageutilities.dragandDrop(totalProjectWidgetLeftColumn, dropWidgetsArea);
		pageutilities.clickOnElement(saveAndShowbutton);
		return this;
		
		
	}
	
	public String totalProjectsCountfromwidgets() {
		waitutility.waitForVisibilityofElement(projectcountinsideWidget);
		String count=pageutilities.getTextOfElement(projectcountinsideWidget);
		return count;
		
	}
	
	
	public void editingDashboard(String uniqueid) {
		
		waitutility.waitForVisibilityofElement(dashboarddropbutton);
		pageutilities.clickOnElement(dashboarddropbutton);
		dropdownitemsdashboard.get(0).click();
		waitutility.waitForVisibilityofElement(ellipsisButton);
		pageutilities.clickOnElement(ellipsisButton);
		pageutilities.clickOnElement(editbuttoninsideEllipsis);
		pageutilities.clearField(createdashboardTitle);
		pageutilities.enterText(createdashboardTitle, uniqueid);
		pageutilities.clickOnElement(saveButton);
		waitutility.waitForInvisibilityofElement(saveButton);
		
	
		
	}
	
	public String validatatingEditDashboard() {
		
		waitutility.waitForVisibilityofElement(titleinsideDashboardView);
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
	

	public void clickOnHomapageTicketsButton() {
		
		pageutilities.clickOnElement(homepageTicketsButton);
	}
	
	
	public void clickOnHomepageInvoicesButton() {
		
		pageutilities.clickOnElement(homepageInvoicesButton);
	}
	
	
	public void clickonHomepageMessagesButton() {
		pageutilities.clickOnElement(homepageMessagesButton);
	}
	
}
