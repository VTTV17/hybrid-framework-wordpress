package pageObjects.OrangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserDetailPageObject extends BasePage {

    WebDriver driver;

    public UserDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
