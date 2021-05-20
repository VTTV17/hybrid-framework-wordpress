package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.wordpress.DashboardPageUI;
import pageUis.wordpress.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	//constructor
	public LoginPageObject(WebDriver driver) {
		this.driver= driver;
	}

	public void inputToUsernameTextbox(String value) {
		waitForElementInvisible(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX, value);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
		
	}

	public boolean isEmptyEmailErrorMessageDisplay() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MGS);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MGS);
	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
		return getTextElement(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
	}

	public void inputToPasswordTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	

	
	
}
