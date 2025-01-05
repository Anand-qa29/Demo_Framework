package Com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import Com.Utility.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import net.bytebuddy.utility.RandomString;

public class TestBase {
	public static WebDriver driver;
	public static Properties props;
	public static final Logger log = LogManager.getLogger(TestBase.class);

	public TestBase() throws IOException {
		props = new Properties();
		props.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Com/qa/config/properties/config"));
	}

	@Parameters("browser")
	@BeforeClass
	public static void initialization() {

		try (FileInputStream fis = new FileInputStream("./src/main/java/Com/qa/config/properties/config")) {
			Properties pro = new Properties();
			pro.load(fis);
			String browser = pro.getProperty("Browser");

			switch (browser.toLowerCase()) {
				case "chrome":
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("start-maximized", "disable-notifications", "--disable-popup-blocking");
					driver = new ChromeDriver(chromeOptions);
					driver.manage().window().maximize();
					break;
				case "msedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					driver.manage().window().maximize();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
					break;
				default:
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();
			}

			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(props.getProperty("url"));
		} catch (IOException e) {
			log.error("Exception: " + e.getMessage());
		}
	}

	public String getScreenShotPath(String testCaseName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String Random = RandomString.make(10);
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+""+Random+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
