package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	PageGeneratorManager generatorManagerPage;
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
		generatorManagerPage= new PageGeneratorManager();
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return 	generatorManagerPage.getRegisterPage(driver);

	}
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return  generatorManagerPage.getLoginPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	public CustomerInfoPageObject clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
		return generatorManagerPage.getCustomerInfoPage(driver);
	}
}
