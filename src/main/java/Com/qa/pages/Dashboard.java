package Com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.qa.base.TestBase;

public class Dashboard extends TestBase{
	
	
	

	public Dashboard() throws IOException {
		PageFactory.initElements(driver,this);
	}


	public List<String> getActualMenuTextList() throws InterruptedException {
		 log.info("User on homepage");
		 List<String> actualMenuTitles = new ArrayList<>();
		for(WebElement menuTitle : listOfSidePanelMenue) {
			actualMenuTitles.add(menuTitle.getText().trim());
		}
		return actualMenuTitles;
	}
	public List<String> getExpectedMenuTextList(){
		return Arrays.asList("Admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard","Directory","Maintenance","Claim", "Buzz");
	}
	public boolean isAdminPageHeadingDisplayed() {
		AdminModule.click();
		return adminModuleHeading.isDisplayed();
	} 
	public String getAdminModuleHeading() {
		return adminModuleHeading.getText();
	}

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	List<WebElement> listOfSidePanelMenue;
	
	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
	private WebElement AdminModule;
	
	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
	private WebElement adminModuleHeading;
	
}
