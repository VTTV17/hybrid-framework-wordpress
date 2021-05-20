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
		return getTextElement(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
	}
	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getTextElement(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
	}
	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getTextElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
	}
}
