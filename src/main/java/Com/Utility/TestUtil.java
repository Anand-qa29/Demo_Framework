package Com.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestUtil {

	public static long IMPLICIT_WAIT = 20;
	public static long PAGE_LOAD_TIMEOUT = 20;
	private static WebDriver driver;

	// Constructor to initialize the driver and page elements
	public TestUtil(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to read data from CSV
	public List<List<String>> data(String path) {
		List<List<String>> rows = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				List<String> row = new ArrayList<>();
				for (String value : values) {
					row.add(value);
				}
				rows.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	// Generic click method with default wait and maximum wait time
	public static void click(WebElement element, int maxWaitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTimeInSeconds));
		try {
			// Set implicit wait for the driver
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

			// Wait for the element to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(element));

			// Scroll to the element
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			// Check if the element is displayed and then click
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (Exception e) {
			// If regular click doesn't work, use JavaScript click
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
	}

	// Generic sendKeys method with default wait and maximum wait time
	public static void sendKeys(WebElement element, String value, int maxWaitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTimeInSeconds));
		try {
			// Set implicit wait for the driver
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

			// Wait for the element to be visible
			wait.until(ExpectedConditions.visibilityOf(element));

			// Scroll to the element
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			// Check if element is displayed and then send keys
			if (element.isDisplayed()) {
				element.sendKeys(value);
			}
		} catch (Exception e) {
			// If regular sendKeys doesn't work, use JavaScript to send keys
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + value + "';", element);
		}
	}

}
