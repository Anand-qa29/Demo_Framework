package Com.qa.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import Com.Utility.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.qa.base.TestBase;

public class login extends TestBase {
	public static Properties props;

	public login() throws IOException {
		PageFactory.initElements(driver, this);
		props = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/TestData/test");
		props.load(ip);
	}

	public Dashboard successfulLogin() throws IOException {
		log.info("User on Login page...");
		TestUtil.sendKeys(userNameFiled, props.getProperty("username"), 20);
		TestUtil.sendKeys(passwordFiled, props.getProperty("password"), 20);
		TestUtil.click(loginButton, 20);
		return new Dashboard();
	}

	public boolean isDashboardHeadingDisplay() {
		log.info("User on Dashboard Page...");
		return dashboardHeading.isDisplayed();
	}

	public void InvalidLogin() {
		log.info("User on Login page...");
		TestUtil.sendKeys(userNameFiled, props.getProperty("invalidusername"), 20);
		TestUtil.sendKeys(passwordFiled, props.getProperty("invalidpassword"), 20);
		TestUtil.click(loginButton, 20);
	}

	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public void Logout() {
		log.info("User on Dashboard page...");
		TestUtil.click(profilDropdown, 20);
		TestUtil.click(Logout, 20);
	}

	public boolean isLoginPageHeadingDisplayed() {
		return loginPageHeading.isDisplayed();
	}

	@FindBy(xpath = "//input[@name='username']")
	protected WebElement userNameFiled;

	@FindBy(xpath = "//input[@name='password']")
	protected WebElement passwordFiled;

	@FindBy(xpath = "//button[@type='submit']")
	protected WebElement loginButton;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	protected WebElement dashboardHeading;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	protected WebElement errorMessage;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	protected WebElement profilDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	protected WebElement Logout;

	@FindBy(xpath = "//h5[text()='Login']")
	protected WebElement loginPageHeading;
}
