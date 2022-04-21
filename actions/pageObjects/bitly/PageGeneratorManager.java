package pageObjects.bitly;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
    public static LandingPageObject getLandingPage(WebDriver driver) {
        return new LandingPageObject(driver);
    }
    public static SignInPageObject getSignInPage(WebDriver driver) {
        return new SignInPageObject(driver);
    }
}
