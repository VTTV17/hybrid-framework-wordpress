package pageObjects.bitly;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.bitly.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateButon() {
        waitForElementClickable(driver, HomePageUI.CREATE_BUTTON);
        clickToElement(driver, HomePageUI.CREATE_BUTTON);
    }

    public void enterLongLink(String longLink) {
        waitForElementVisible(driver, HomePageUI.LONG_URL_TEXTAREA);
        sendKeyToElement(driver, HomePageUI.LONG_URL_TEXTAREA,longLink);
    }

    public void enterSource(String randomAlphanumeric) {
        waitForElementVisible(driver, HomePageUI.SOURCE_INPUT);
        sendKeyToElement(driver, HomePageUI.SOURCE_INPUT,randomAlphanumeric);
    }

    public void clickToCreatSubmit() {
        waitForElementClickable(driver, HomePageUI.CREATE_SUBMIT_BUTTON);
        clickToElement(driver, HomePageUI.CREATE_SUBMIT_BUTTON);
    }

    public String getShortLink() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        waitForElementDisplay(driver, HomePageUI.SHORT_LINK);
        return getAttributeValue(driver,HomePageUI.SHORT_LINK,"href");
    }

    public void clickCloseIcon() {
        waitForElementClickable(driver, HomePageUI.CLOSE_BUTTON);
        clickToElement(driver, HomePageUI.CLOSE_BUTTON);
    }
}
