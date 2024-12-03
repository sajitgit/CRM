package TestScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
public WebDriver driver;//declare
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserinitialization(String browsername) throws Exception {
		
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			
			driver= new ChromeDriver();
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //If page loads in 2 seconds it will skip remaining 3 seconds.(if thread.sleep it will wait forcefully 5 seconds)
		
	}

}
