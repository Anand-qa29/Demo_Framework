package Com.qa.base;


import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import Com.Utility.ReadConfig;




public class BaseClass {
	
	
	public WebDriver driver;
	public static Logger logger;
	
	ReadConfig readcofig= new ReadConfig();
	String name=readcofig.getbrowser();
	public  String url= readcofig.getApplicationUrl();
	public String email=readcofig.getusername();
	public String pass=readcofig.getpassword();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver",name);
		driver =new ChromeDriver(option);
		driver.get(url);
		
	
	}
	@AfterClass
	public void teardown() {
		
	}
	
	

}
