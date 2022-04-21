package pageObjects.OrangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.OrangeHRM.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends BasePage {

    WebDriver driver;

    public EmployeeDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
    waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_ADD_EMPLOYEE_FORM);
    sendKeyToElement(driver,EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_ADD_EMPLOYEE_FORM,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_ADD_EMPLOYEE_FORM);
        sendKeyToElement(driver,EmployeeDetailPageUI.LASTNAME_TEXTBOX_ADD_EMPLOYEE_FORM,lastName);
    }

    public String getEmployeeIDAtAddEmployeeForm() {
        waitForElementVisible(driver,EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_ADD_EMPLOYEE_FORM);
        return getAttributeValue(driver,EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_ADD_EMPLOYEE_FORM,"value");
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver,EmployeeDetailPageUI.SAVE_BUTTON_ADD_EMPLOYEE_FORM);
        clickToElement(driver,EmployeeDetailPageUI.SAVE_BUTTON_ADD_EMPLOYEE_FORM);
    }

    public boolean isFullNameDisplayAtHeader(String fullName) {
        waitForElementVisible(driver,EmployeeDetailPageUI.DYNAMIC_FULLNAME_HEADER_PERSONAL_DETAIL_FORM,fullName);
        return isElementDisplayed(driver,EmployeeDetailPageUI.DYNAMIC_FULLNAME_HEADER_PERSONAL_DETAIL_FORM,fullName);
    }

    public Object getFirstNameValueAtPersonalDetailForm() {
        waitForElementVisible(driver,EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_DETAIL_FORM);
        return getTextElement(driver,EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_PERSONAL_DETAIL_FORM);
    }

    public Object getLastNameValueAtPersonalDetailForm() {
        waitForElementVisible(driver,EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_DETAIL_FORM);
        return getTextElement(driver,EmployeeDetailPageUI.LASTNAME_TEXTBOX_PERSONAL_DETAIL_FORM);
    }

    public Object getEmployeeIDValueAtPersonalDetailForm() {
        waitForElementVisible(driver,EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_PERSONAL_DETAIL_FORM);
        return getAttributeValue(driver,EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_PERSONAL_DETAIL_FORM,"value");
    }
}
