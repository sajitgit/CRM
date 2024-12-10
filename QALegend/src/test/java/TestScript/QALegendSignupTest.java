package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakerUtility;

public class QALegendSignupTest extends BaseClass {
	
	
	@Test
	public void signup() {
		
		driver.get(prop.getProperty("url2"));
		String email = FakerUtility.uniqueStringGenerator()+"testcompany@yopmail.com";
		signuppage.enterSignupDetails(prop.getProperty("signupfirstname"),prop.getProperty("signuplastname"),prop.getProperty("company"),email,prop.getProperty("signuppassword"));
		Assert.assertEquals(signuppage.getAlertDetails(), "Your account has been created successfully! Sign in");
	}
	
	


}
