package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	PageGeneratorManager generatorManagerPage;
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
		generatorManagerPage= new PageGeneratorManager();
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return generatorManagerPage.getHomePage(driver);
		
	}
	public void enterToPasswordTextbox(String passW) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passW);		
	}
	
}
