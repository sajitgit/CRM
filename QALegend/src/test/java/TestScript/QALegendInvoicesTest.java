package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QALegendInvoicesTest extends BaseClass{
		
	
	
	@Test
	public void validatingInvoiceAmount() {
			
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.clickOnHomepageInvoicesButton();
		Assert.assertEquals(invoicespage.checkingInvoiceAmount(), invoicespage.checkingTotal());
		
	}

	
	@Test
	public  void eyeButtonFunctionality() {
		
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.clickOnHomepageInvoicesButton();
		invoicespage.eyebutton();
		Assert.assertFalse(invoicespage.eyebuttonFunctionality());
		
	}

}
