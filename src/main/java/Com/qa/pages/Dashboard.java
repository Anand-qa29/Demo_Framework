package Com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Utility.TestUtil;
import Com.qa.base.TestBase;

public class Dashboard extends TestBase {

	// Declare TestUtil for using generic methods
	TestUtil util = new TestUtil(driver);

	// Constructor to initialize the page elements
	public Dashboard() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Method to get actual menu titles from the side panel
	public List<String> getActualMenuTextList() throws InterruptedException {
		log.info("User on homepage");
		List<String> actualMenuTitles = new ArrayList<>();
		for (WebElement menuTitle : listOfSidePanelMenu) {
			actualMenuTitles.add(menuTitle.getText().trim());
		}
		return actualMenuTitles;
	}

	// Expected menu titles
	public List<String> getExpectedMenuTextList() {
		return Arrays.asList("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard",
				"Directory", "Maintenance", "Claim", "Buzz");
	}

	// Method to check if Admin page heading is displayed
	public boolean isAdminPageHeadingDisplayed() {
		// Using the generic click method from TestUtil to click Admin module
		util.click(AdminModule, 20);
		return adminModuleHeading.isDisplayed();
	}

	// Method to get the Admin module heading text
	public String getAdminModuleHeading() {
		return adminModuleHeading.getText();
	}

	// WebElements using Page Factory
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	List<WebElement> listOfSidePanelMenu;

	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
	protected WebElement AdminModule;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
	protected WebElement adminModuleHeading;
}
