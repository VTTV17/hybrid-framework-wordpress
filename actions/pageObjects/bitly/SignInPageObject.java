package pageObjects.bitly;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.bitly.HomePageUI;
import pageUis.bitly.SignInPageUI;

public class SignInPageObject extends BasePage {
    WebDriver driver;

    public SignInPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        waitForElementVisible(driver, SignInPageUI.EMAIL_TEXT_FIELD);
        sendKeyToElement(driver,SignInPageUI.EMAIL_TEXT_FIELD,email);
    }

    public void enterPass(String password) {
        waitForElementVisible(driver, SignInPageUI.PASSWORD_TEXT_FIELD);
        sendKeyToElement(driver,SignInPageUI.PASSWORD_TEXT_FIELD,password);
    }

    public HomePageObject clickToLoginButon() {
        waitForElementClickable(driver, SignInPageUI.LOGIN_BUTTON);
        clickToElement(driver,SignInPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }
}
