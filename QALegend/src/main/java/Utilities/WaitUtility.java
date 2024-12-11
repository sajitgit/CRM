package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.ConstantValues;

public class WaitUtility {

public  WebDriver driver;
	
public WaitUtility(WebDriver driver) {
		this.driver=driver;
	}


public void waitForVisibilityofElement(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantValues.EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

public void waitForInvisibilityofElement(WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantValues.EXPLICITWAIT));
	wait.until(ExpectedConditions.invisibilityOf(element));
	
}


public void waitForClickingElement(WebDriver driver,WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantValues.EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
	
}

public void waitForTextTObePresentInElement(WebDriver driver,WebElement element,String text) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantValues.EXPLICITWAIT));
	wait.until(ExpectedConditions.textToBePresentInElement(element, text));
}


public void waitForELementToBeSelected(WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantValues.EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeSelected(element));
	
}


public void waitForAttributeofElement(WebElement element,String Attribute,String value) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantValues.EXPLICITWAIT));
	wait.until(ExpectedConditions.attributeToBe(element, Attribute, value));
}




}
