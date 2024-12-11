package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QALegendLoginTest extends BaseClass {

	
	@Test
	public void urlValidation() {
		
		Assert.assertEquals(loginpage.urlVerify(), "https://qalegend.com/crm/index.php/signin");
	}
	
	@Test
	public void loginuserlogin() {
		loginpage.login(prop.getProperty("loginuser"), prop.getProperty("loginpassword"));
		Assert.assertEquals(homepage.getUsernameText(), prop.getProperty("loginusername"));
		
	}
}