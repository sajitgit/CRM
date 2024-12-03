package Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtilities {

	
	private WebDriver driver;
	
	
	public void clickOnElement(WebElement element) {
		
		
		element.click();
	}
	
	public void selectByIndex(WebElement dropdown,int index) {
		
		
		Select drp = new Select(dropdown);
		drp.selectByIndex(index);
		
	}
	
	public void selectByVisibleText(WebElement dropdown,String text) {
		
		Select drp = new Select(dropdown);
		drp.selectByVisibleText(text);
		
	}
	
	
	public void selectByValue(WebElement dropdown,String value) {
		
		Select drp = new Select(dropdown);
		drp.selectByValue(value);
	}
	
	public void dragandDrop(WebElement source,WebElement destination) {
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).build().perform();
	}
	
	public void mouseHover(WebElement element) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void rightClick() {
		
		Actions act = new Actions(driver);
		act.contextClick().build().perform();
	}
	
	public void enterText(WebElement element,String Text ) {
		element.sendKeys(Text);
		
	}
	
	public void javascriptClick(WebElement element) {
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("arguments[0].click();",element);
	}
	
	public void javascriptScroll() {
		JavascriptExecutor jsc = (JavascriptExecutor)driver;
		jsc.executeScript("window.scrollBy(0,1000)");
	}
	
	public void waitForVisibility(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForInvisibility(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public String getTextOfElement(WebElement element) {
		
		String text = element.getText();
		return text;
	}
	
	public String getAttributeOfElement(WebElement element,String atrname) {
		element.getAttribute(atrname);
		return atrname;
		
	}
	public void clearField(WebElement element) {
		
		element.clear();
	}
	
	public boolean isElementEnabled(WebElement element) {
		boolean status = element.isEnabled();
		return status;
	}
	
	public boolean isElementDisplayed(WebElement element) {	
		boolean status = element.isDisplayed();
		return status;
	}
	
	public void switchToWindow() {
			
			String parent = driver.getWindowHandle();
			Set<String> tabs = driver.getWindowHandles();
			Iterator<String>it = tabs.iterator();
			while(it.hasNext()) {
				String child = it.next();
					if(!parent.equals(child)) {
					driver.switchTo().window(child);
				}
			}
		}
	
	
	public void alertAccept() {
		
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss() {
		
		driver.switchTo().alert().dismiss();
	}
	
	public void keyBoardEnter() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
	}
	
	public void keyBoardTab() {
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		
	}
	
	
}
