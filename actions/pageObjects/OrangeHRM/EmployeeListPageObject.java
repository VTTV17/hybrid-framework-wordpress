package pageObjects.OrangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.OrangeHRM.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePage {

    WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeDetailPageObject clickToAddButton() {
        waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
        clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
        return PageGeneratorManager.getLEmployeeDetailPage(driver);
    }
}
