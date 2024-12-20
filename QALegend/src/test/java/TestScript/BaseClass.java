package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Constants.ConstantValues;
import PageClasses.QALegendEstimatesPage;
import PageClasses.QALegendEventPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendInvoicesPage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendMessagesPage;
import PageClasses.QALegendSignUpPage;
import PageClasses.QALegendTicketsPage;
import Utilities.ScreenshotUtility;

public class BaseClass {
	
	
public WebDriver driver;//declare

    QALegendLoginPage loginpage ;
    QALegendHomePage homepage;
    QALegendEventPage eventpage;
    QALegendSignUpPage signuppage;
    QALegendEstimatesPage estimatespage;
    QALegendTicketsPage ticketspage;
    QALegendInvoicesPage invoicespage;
    QALegendMessagesPage messagespage;
    
    
    public Properties prop;
    public FileInputStream fis;
    String browsername = "chrome";
	
	@BeforeMethod(alwaysRun = true)
	//@Parameters({"browser"})
	
	public void browserinitialization() throws Exception {
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		else if (browsername.equalsIgnoreCase("Firefox")){
			
			driver = new FirefoxDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("Edge")) {
			
			
			driver = new EdgeDriver();
		}
		
		else {
			
			throw new Exception("Invalid name exception");
		}
		
		prop=new Properties();
		fis= new FileInputStream(ConstantValues.USERDATAFILE);
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginpage = new QALegendLoginPage(driver);
		homepage = new QALegendHomePage(driver);
		eventpage = new QALegendEventPage(driver);
		signuppage=new QALegendSignUpPage(driver);
		estimatespage = new QALegendEstimatesPage(driver);
		ticketspage = new QALegendTicketsPage(driver);
		invoicespage = new QALegendInvoicesPage(driver);
		messagespage = new QALegendMessagesPage(driver);
		
	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult itResult) throws IOException {
		
		if(itResult.getStatus()==ITestResult.FAILURE) {
			
			ScreenshotUtility sc = new ScreenshotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		
		if(driver!=null) {
			
			driver.quit();
		}
	}

}
