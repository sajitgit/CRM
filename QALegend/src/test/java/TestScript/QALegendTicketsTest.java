package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;

public class QALegendTicketsTest extends BaseClass {

	
	@Test
	public void createTicket() throws IOException {
		
		
		String title = ExcelUtility.getStringData(1, 3, "Sheet1");
		String titledescription = ExcelUtility.getStringData(1, 4, "Sheet1");		
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.clickOnHomapageTicketsButton();
		ticketspage.creatingnewTicket(title, titledescription);
		Assert.assertEquals(ticketspage.validatingnewstatus(), "New");
		ticketspage.closingNewTicket();
		Assert.assertEquals(ticketspage.validatingclosedStatus(), "Closed");
	}
	
}
