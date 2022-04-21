package pageObjects.bitly;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.bitly.LandingPageUI;

public class LandingPageObject extends BasePage {
    WebDriver driver;

    public LandingPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPageObject clickToLoginLink() {
        waitForElementClickable(driver, LandingPageUI.LOGIN_LINK);
        clickToElement(driver, LandingPageUI.LOGIN_LINK);
        return PageGeneratorManager.getSignInPage(driver);
    }
}
