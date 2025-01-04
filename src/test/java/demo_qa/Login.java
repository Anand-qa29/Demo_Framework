package demo_qa;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.qa.base.TestBase;
import Com.qa.pages.login;

public class Login extends TestBase {

	public Login() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void openBrowser() throws IOException, InterruptedException {
		initialization();
	}

	@Test(priority = 1)
	public void Verify_Login_with_Invalid_credential() throws IOException {
		login lp = new login();
		lp.Invaid_Login();
		Assert.assertTrue(lp.is_error_message_display(), "Error message is not Display");
		Assert.assertEquals(lp.getErrorMessage(), "Invalid credentials", "Actual and Expected message is not match");
	}

	@Test(priority = 2)
	public void Verify_user_can_log_in_with_valid_credential() throws InterruptedException, IOException {
		login lp = new login();
		lp.successfulLogin();
		Assert.assertTrue(lp.isDashboardHeadingDisplay(), "Dashboard Heading is not Display");
	}

	@Test(priority = 3)
	public void Verify_Logout() throws IOException {
		login lp = new login();
		lp.Logout();
		Assert.assertTrue(lp.isLoginPageHeadingDisplayed(), "Login page is not Displayed");
	}

	@AfterClass
	public void TearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
		Thread.sleep(2000);
	}

}
