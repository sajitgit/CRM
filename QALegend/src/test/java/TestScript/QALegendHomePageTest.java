package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakerUtility;

public class QALegendHomePageTest extends BaseClass {

	@Test
	public void createnewDashboard() {
		
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.creatingnewDashboard();
		Assert.assertEquals(homepage.totalProjectsCountfromwidgets(), "1");
		
	}
	
	@Test
	public void editDashboard() {
		
		String uniqueString = FakerUtility.uniqueStringGenerator();
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.editingDashboard(uniqueString);
		Assert.assertEquals(homepage.validatatingEditDashboard(), uniqueString);
		//deleting dashboard for automation feasibility
		homepage.deletingDashboard();
		
		
	}
}
