package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;

public class QALegendEstimatesTest extends BaseClass{

	
	@Test(retryAnalyzer = TestScript.RetryAnalyser.class)
	public void createEstimate() throws IOException {
		
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		String field = ExcelUtility.getStringData(1, 2, "Sheet1");
		homepage.clickOnEstimatesButton();
		estimatespage.creatinganEstimate(field);
		Assert.assertEquals(estimatespage.createEstimateAlertValidation(), "Your request has been submitted successfully!");
		
		
		
	}
	
}
