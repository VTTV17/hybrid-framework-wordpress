package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.wordpress.DashboardPageUI;

public class DashboardPageObject extends BasePage {
	WebDriver driver;
	public DashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isDashboardTitleDisplay() {
		// TODO Auto-generated method stub
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_TITLE);
	}
	public void clickToScreenOptionButton() {
		waitForElementClickable(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
	}
	public boolean isActivityCheckboxDisplayed() {
		waitForElementVisible(driver,  DashboardPageUI.ACTIVITY_CHECKBOX);
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}
	public boolean isActivityCheckboxUnDisplayed() {
		waitForElementInvisible(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}
	public boolean isPostSearchTextboxUnDisplayed() {
		return isElementUndisplayed(driver, DashboardPageUI.POST_SEARCH_TEXTBOX);
	}
}
