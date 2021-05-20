package pageFactory.NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Emai")
	private WebElement emailTextbox; 
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	@FindBy(css=".login-button")
	private WebElement loginButton;
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(emailTextbox, email);
	}
	public void enterToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(passwordTextbox, passWord);
	}
	public void clickToLoginButton() {
		waitForElementVisible(driver, loginButton);
		clickToElement(loginButton);
	}


}
