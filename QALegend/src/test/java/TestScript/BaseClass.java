package TestScript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import Constants.ConstantValues;
import PageClasses.QALegendEventPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendSignUpPage;

public class BaseClass {
	
	
public WebDriver driver;//declare

    QALegendLoginPage loginpage ;
    QALegendHomePage homepage;
    QALegendEventPage eventpage;
    QALegendSignUpPage signuppage;
    
    
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
		
	
	}

}
