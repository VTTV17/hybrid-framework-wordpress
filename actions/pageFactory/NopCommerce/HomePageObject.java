package pageFactory.NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".ico-register")
	private WebElement registerLink;
	
	@FindBy(css=".ico-login")
	private WebElement loginLink;
	
	@FindBy(css=".ico-account")
	private WebElement myAccountLink;
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(registerLink);
	}
	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(loginLink);
	}
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(myAccountLink);
	}
}
