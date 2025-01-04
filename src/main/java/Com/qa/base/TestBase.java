package Com.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import Com.Utility.CompanyData;
import Com.Utility.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;


public class TestBase {
	public static WebDriver driver;
	public static Properties props;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	
	
	CompanyData co=new CompanyData();
	public String br =co.Browser();
	
	public TestBase() throws IOException {
		
		
		props = new Properties();
		//FileInputStream ip =  new FileInputStream("C:\\Users\\ganesh_moontechnolab\\eclipse-workspace\\MavenStructure\\src\\main\\java\\config\\properties\\config");
		FileInputStream ip =  new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Com/qa/config/properties/config");
	//	/src/main/java/Com/config/properties/config
		//./Configuration/config.properties
	//	FileInputStream ip =  new FileInputStream(System.getProperty(("user.dir")+"\\Configuration\\data"));
//		//C:\\Users\\ganesh_moontechnolab\\eclipse-workspace\\MavenStructure\\src\\main\\java\\config\\properties\\config
		props.load(ip);							
	}
	
	
	
	
@Parameters("browser")
@SuppressWarnings("deprecation")
public static void initialization() throws InterruptedException {
	CompanyData co=new CompanyData();
	String br =co.Browser();
	
	
	
	
	
	if(br.equals("chrome")) {
		
		ChromeOptions option =new ChromeOptions();
		Map < String, Object > prefs = new HashMap < String, Object > ();
	    Map < String, Object > profile = new HashMap < String, Object > ();
	    Map < String, Object > contentSettings = new HashMap < String, Object > ();

	    // SET CHROME OPTIONS
	    // 0 - Default, 1 - Allow, 2 - Block
	    contentSettings.put("geolocation", 2);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    //option.setExperimentalOption("prefs", prefs);

//		//option.addArguments("--headless");
		option.addArguments("--disable-notifications");	
		
		option.addArguments("--disable-popup-blocking");
		
	//	option.addUserProfilePreference("autofill.profile_enabled", false);
		
	/*	options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-save-password-bubble");*/
		
	    
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		
	   // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
	    Map<String, Object> prefs1 = new HashMap<String, Object>();
	    prefs1.put("profile.default_content_setting_values.autofill.profile_enabled", 2);
	    prefs1.put("credentials_enable_service", false);
	    prefs1.put("profile.password_manager_enabled", false);
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	  //  options.addArguments("Headless");
	    options.addArguments("window-size=1920,1080");
	   // options.addArguments("--window-size=1920,1080");
		
	    options.setExperimentalOption("prefs", prefs1);
	    options.addArguments("start-maximized");
	    options.addArguments("disable-infobars");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-popup-blocking");

	    
	    
	   driver = new ChromeDriver(options);
		
	  //   driver = new ChromeDriver(options); 
	     
	     driver.manage().window().maximize();
	     
	     driver.manage().deleteAllCookies();
	     
	     driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	     
	     driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
	}
	else if(br.equals("msedge")) {		
		
		
		  System.setProperty("webdriver.msedge.driver",System.getProperty("user.dir")+"/Drivers/msedgedriver.exe");
		    
//			WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver(); 
		     
		     driver.manage().window().maximize();
		     
		     driver.manage().deleteAllCookies();
		     
		     driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		     
		     driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		     
		    
		
	}else if (br.equals("chrommanager")) 
	{
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		System.out.println("demo");
		driver.manage().window().maximize();
		System.out.println("Demo1");

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	}
	else if(br.equals("ie")) {		
		
		
		 System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
		  
		    			
		     driver = new InternetExplorerDriver(); 
		     
		     driver.manage().window().maximize();
		     
		     driver.manage().deleteAllCookies();
		     
		     driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		     
		     driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		     
		
	}
	 driver.get(props.getProperty("url"));
	 Thread.sleep(2000);
	// Cast the driver to JavascriptExecutor
	JavascriptExecutor js = (JavascriptExecutor) driver;

//	// Zoom in by setting the page zoom level to 125%
//	js.executeScript("document.body.style.zoom='125%'");

	// Alternatively, zoom out by setting the page zoom level to 75%
	
	// Default size
			Dimension currentDimension = driver.manage().window().getSize();
			int height = currentDimension.getHeight();
			int width = currentDimension.getWidth();
			System.out.println("Current height: "+ height);
			System.out.println("Current width: "+width);
			Thread.sleep(2000);
			

			driver.get(props.getProperty("url"));
			 Thread.sleep(2000);
			


	     
	    
		
	}
           
public  String getScreenShotPath(String testCaseName) throws IOException

{

	TakesScreenshot ts= (TakesScreenshot) driver;
	
	File source = ts.getScreenshotAs(OutputType.FILE);
	
	String Random = RandomString.make(10);
	
	String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+""+Random+".png";
	
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
  }


public static WebElement Teardown() throws InterruptedException {
	
	driver.navigate().refresh();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[@class=\"avatar_dropdown\"]")).click();
	Thread.sleep(2000);
	WebElement logout=  driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
	logout.click();
	Thread.sleep(2000);

	Thread.sleep(2000);
	driver.quit();
	Thread.sleep(2000);
	return logout;
	
}
	

	
	
	
	
	
	

}
