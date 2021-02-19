package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.DashboardPageUI;

public class DashboardPageObject extends BasePage {
	WebDriver driver;
	public DashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isDashboardTitleDisplay() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_TITLE);
	}
}
