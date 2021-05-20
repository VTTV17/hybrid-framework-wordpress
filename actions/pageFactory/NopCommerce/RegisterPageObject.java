package pageFactory.NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePage {
WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="FirstName")
	private WebElement firstNameTextbox;
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;
	@FindBy(id="Email")
	private WebElement emailTextbox;
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassWTextbox;
	@FindBy(id="register-button")
	private WebElement registerButton;
	@FindBy(xpath="//div[@class='result' and text()='Your registration completed']")
	private WebElement successMessage;
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement logoutButton;
	
	public void enterToFirstName(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(firstNameTextbox, firstName);
	}
	public void enterToLastName(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendKeyToElement(firstNameTextbox, lastName);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(firstNameTextbox, email);		
	}
	public void enterToPasswordTextbox(String passWord) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(firstNameTextbox, passWord);		
	}
	public void enterToComfirmPasswordTextbox(String passWord) {
		waitForElementVisible(driver, confirmPassWTextbox);
		sendKeyToElement(firstNameTextbox, passWord);		
	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(registerButton);
	}
	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(successMessage);
	}
	public void clickToLogOutLink() {
		waitForElementClickable(driver, logoutButton);
		clickToElement(logoutButton);		
	}


}
