package demo_qa;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import Com.qa.base.TestBase;
import Com.qa.pages.Dashboard;
import Com.qa.pages.login;

public class Verify_Dashboard extends TestBase {

	public Verify_Dashboard() throws IOException {
		super();
	}

	@Test(priority = 1)
	public void verify_SidePanel_List() throws InterruptedException, IOException {
		login login = new login();
		Dashboard dashboard = login.successfulLogin();
		List<String> actualMenuTitles = dashboard.getActualMenuTextList();
		List<String> expectedMenuTitles = dashboard.getExpectedMenuTextList();
		for (int i = 0; i < actualMenuTitles.size(); i++) {
			Assert.assertEquals(actualMenuTitles.get(i), expectedMenuTitles.get(i), "Mismatch found at index " + i
					+ ": Expected '" + expectedMenuTitles.get(i) + "', but got '" + actualMenuTitles.get(i) + "'");
		}
	}

	@Test(priority = 2)
	public void verify_Admin_Module_Heading() throws IOException {
		Dashboard dp = new Dashboard();
		Assert.assertTrue(dp.isAdminPageHeadingDisplayed(), "Admin Module Heading is not Displayed");
		Assert.assertEquals(dp.getAdminModuleHeading(), "Admin", "Expected and Acrual is not match");
	}
}
