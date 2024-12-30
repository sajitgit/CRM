package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakerUtility;

public class QALegendHomePageTest extends BaseClass {

	@Test(retryAnalyzer = TestScript.RetryAnalyser.class)
	public void createnewDashboard() {
		
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.creatingnewDashboard();
		Assert.assertEquals(homepage.totalProjectsCountfromwidgets(), "1");
		
	}
	
	@Test(retryAnalyzer = TestScript.RetryAnalyser.class)
	public void editDashboard() {
		
		String uniqueString = FakerUtility.uniqueStringGenerator();
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.editingDashboard(uniqueString);
		Assert.assertEquals(homepage.validatatingEditDashboard(), uniqueString);
		//deleting dashboard for automation feasibility
		homepage.deletingDashboard();
		
		
	}
}
