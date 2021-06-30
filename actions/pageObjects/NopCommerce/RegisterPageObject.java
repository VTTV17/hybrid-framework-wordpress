package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	WebDriver driver;
	PageGeneratorManager generatorManagerPage;
	public RegisterPageObject(WebDriver driver) {
		this.driver=driver;
		generatorManagerPage= new PageGeneratorManager();
	}
	public void enterToFirstName(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToLastName(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	public void enterToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passWord);
	}
	public void enterToComfirmPasswordTextbox(String confirmPass) {
		waitForElementVisible(driver, RegisterPageUI.COMFIRM_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMFIRM_TEXTBOX, confirmPass);
		
	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	public boolean isSuccessMessageDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}
	public HomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return generatorManagerPage.getHomePage(driver);
	}
	
}
