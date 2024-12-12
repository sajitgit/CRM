package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakerUtility;

public class QALegendSignupTest extends BaseClass {
	
	public String email;
	
	@Test()
	public  void registeringUser() {
		
		driver.get(prop.getProperty("url2"));
	    String email = FakerUtility.uniqueStringGenerator()+"testcompany@yopmail.com";
	    this.email=email;
		signuppage.enterSignupDetails(prop.getProperty("signupfirstname"),prop.getProperty("signuplastname"),prop.getProperty("company"),email,prop.getProperty("signuppassword"));
		Assert.assertEquals(signuppage.getAlertDetails(), "Your account has been created successfully! Sign in");
	}
	
	@Test
	public void signedupUserSignin() {
				
		loginpage.login(email,prop.getProperty("signuppassword"));
		Assert.assertEquals(homepage.usernameisDisplayedorNot(), true);
		
		
	}


}
