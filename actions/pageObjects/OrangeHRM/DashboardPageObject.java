package pageObjects.OrangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage {

    WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
