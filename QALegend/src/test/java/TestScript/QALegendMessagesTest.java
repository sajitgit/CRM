package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakerUtility;

public class QALegendMessagesTest extends BaseClass{

	
	@Test
	public void composingAMessage() {
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickonHomepageMessagesButton();
		String messageText = "Hello"+FakerUtility.uniqueStringGenerator();
		String userforMessaging = prop.getProperty("messageuser");
		messagespage.composeMessage(userforMessaging,messageText);
		Assert.assertEquals(messageText, messagespage.validatingMessageSent(userforMessaging));
		
	}
}
