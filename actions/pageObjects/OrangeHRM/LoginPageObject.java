package pageObjects.OrangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.OrangeHRM.LoginPageUI;

public class LoginPageObject extends BasePage {

    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String userName) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.USERNAME_TEXTBOX,userName);
    }

    public void enterToPasswordTextbox(String passWord) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,passWord);
    }

    public DashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getDashboardPage(driver);
    }
}
