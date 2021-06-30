package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.nopCommerce.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX,"value");
	}
	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX,"value");
	}
	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX,"value");
	}
}
