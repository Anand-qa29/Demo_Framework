package Com.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestUtil {

	public static long IMPLICIT_WAIT = 20;
	public static long PAGE_LOAD_TIMEOUT = 20;
	private static WebDriver driver;

	public TestUtil(WebDriver driver) {
		TestUtil.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click(WebElement element, int maxWaitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTimeInSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
	}

	public void sendKeys(WebElement element, String value, int maxWaitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTimeInSeconds));
		try {
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			if (element.isDisplayed()) {
				element.sendKeys(value);
			}
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + value + "';", element);
		}
	}

}
