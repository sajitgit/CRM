package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendTicketsTest extends BaseClass {

	
	@Test(retryAnalyzer = TestScript.RetryAnalyser.class)
	public void createTicket() throws IOException {
		
		
		String title = prop.getProperty("bugname")+FakerUtility.uniqueStringGenerator();
		String titledescription = prop.getProperty("bugdescription");		
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.clickOnHomapageTicketsButton();
		ticketspage.creatingnewTicket(title, titledescription);
		ticketspage.searchingBug(title);
		Assert.assertEquals(ticketspage.validatingnewstatus(), "New");
		ticketspage.closingNewTicket();
		Assert.assertEquals(ticketspage.validatingclosedStatus(), "Closed");
	}
	
}
