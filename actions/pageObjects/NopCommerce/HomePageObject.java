package pageObjects.NopCommerce;

import io.qameta.allure.Step;
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
	@Step("Click on register link")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return 	generatorManagerPage.getRegisterPage(driver);

	}
	@Step("Click on Login link")
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return  generatorManagerPage.getLoginPage(driver);
	}
	@Step("Verify my account link display")
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	@Step("Click on my account link")
	public CustomerInfoPageObject clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
		return generatorManagerPage.getCustomerInfoPage(driver);
	}
}
