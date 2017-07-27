package StepDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.BaseUtil;
import Utilities.Constants;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseUtil {

	public static WebDriver driver;
	public static Scenario sc;
	public static Pages.Contact cs;
	
	private BaseUtil base;
	
	public Hook(BaseUtil base){
	this.base= base;
	base.Browser = Constants.browser;
	}

	@Before("@web")
	public void initializeTest(Scenario scenario){
		
		if(base.Browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+Constants.GeckoDriverLoc);
			driver = new FirefoxDriver();		
		}
		else if (base.Browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ Constants.ChromeDriverLoc);
			driver = new ChromeDriver();
		}
		else if (base.Browser.equals("IE")){
			//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		cs = new Pages.Contact(driver);
		this.sc =scenario;
		System.out.println("Executing Scenario  " +sc.getName());
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Scenario getScenario() {
		return sc;
	}
	
	@After("@web")
	public void tearDown(Scenario scenario){
		scenario.write("Finished Scenario");
		//if(scenario.isFailed()) {
			//scenario.embed(arg0, arg1); //Screenshot code
	//	}
		driver.close();
		driver.quit();
	}
		/*	System.out.println(scenario.getStatus());
			//try {
	          //  File scrFile = getScreenShotFile();
			//	byte[] data = FileUtils.readFileToByteArray(scrFile);
			//	scenario.embed(data, "image/png");
		    //} catch (Exception e) {
		     //   e.printStackTrace();
		System.out.println("GGG");   
		
	}*/
	
	
	
}
