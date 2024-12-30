package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QALegendInvoicesTest extends BaseClass{
		
	
	
	@Test(retryAnalyzer = TestScript.RetryAnalyser.class)
	public void validatingInvoiceAmount() {
			
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.clickOnHomepageInvoicesButton();
		Assert.assertEquals(invoicespage.checkingInvoiceAmount(), invoicespage.checkingTotal());
		
	}

	
	@Test(retryAnalyzer = TestScript.RetryAnalyser.class)
	public  void eyeButtonFunctionality() {
		
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		homepage.clickOnHomepageInvoicesButton();
		invoicespage.eyebutton();
		Assert.assertFalse(invoicespage.eyebuttonFunctionality());
		
	}

}
