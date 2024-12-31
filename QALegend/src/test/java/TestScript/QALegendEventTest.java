package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.ConstantValues;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendEventTest extends BaseClass{

	
	@Test(retryAnalyzer = TestScript.RetryAnalyser.class)
	public void addanEvent() throws IOException {
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnHomePageEventButton();
		eventpage.clickOnAddEventButton();
		
		String eventTitle = ExcelUtility.getStringData(1, 0,ConstantValues.TESTDATAFILE, "Sheet1")+FakerUtility.randomNumberGenerator();
		String eventDescription = ExcelUtility.getStringData(1, 1,ConstantValues.TESTDATAFILE, "Sheet1");
		eventpage.eventDetails(eventTitle, eventDescription);
		Assert.assertEquals(eventpage.eventPageSaveButtonStatusChecker(), true);
		
	}
	
	
	
}
