package Com.qa.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.qa.base.TestBase;

public class login extends TestBase {
	public static Properties props;

	public login() throws IOException {
		PageFactory.initElements(driver, this);
		props = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/Com/qa/config/properties/config");
		props.load(ip);
	}

	public Dashboard successfulLogin() throws IOException {
		log.info("User on Login page...");
		userNameFiled.sendKeys(props.getProperty("username"));
		passwordFiled.sendKeys(props.getProperty("password"));
		loginButton.click();
		return new Dashboard();	
		}

	public boolean isDashboardHeadingDisplay() {
		log.info("User on Dashboard Page...");
		return dashboardHeading.isDisplayed();
	}

	public void Invaid_Login() {
		log.info("User on Login page...");
		userNameFiled.sendKeys(props.getProperty("invalidusername"));
		passwordFiled.sendKeys(props.getProperty("invalidpassword"));
		loginButton.click();
	}

	public boolean is_error_message_display() {
		return errorMessage.isDisplayed();

	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public void Logout() {
		log.info("User on Dashboard page...");
		profilDropdown.click();
		Logout.click();
	}

	public boolean isLoginPageHeadingDisplayed() {
		return loginPageHeading.isDisplayed();
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameFiled;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordFiled;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardHeading;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	private WebElement errorMessage;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement profilDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement Logout;

	@FindBy(xpath = "//h5[text()='Login']")
	private WebElement loginPageHeading;
}
