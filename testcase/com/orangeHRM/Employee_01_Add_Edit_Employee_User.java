package com.orangeHRM;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.OrangeHRM.*;

public class Employee_01_Add_Edit_Employee_User extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    EmployeeDetailPageObject employeeDetailPage;
    UserDetailPageObject userDetailPage;
    EmployeeListPageObject employeeListPage;
    String lastName, firstName,employeeID;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver= getBrowserDriver(browserName);
        driver.get(url);
        lastName="Automation" + getRandom();
        firstName="Testing"+ getRandom();

        log.info("Pre-condition: Enter to username textbox:");
        loginPage.enterToUserNameTextbox("");
        log.info("Pre-condition: Enter to password textbox:");
        loginPage.enterToPasswordTextbox("");
        log.info("Pre-condition: Click to login button:");
        dashboardPage= loginPage.clickToLoginButton();
    }
    @Test
    public void Employee_01_Add_Employee(){
        dashboardPage.openDynamicMenuLink(driver,"PIM");
        employeeListPage=PageGeneratorManager.getEmployeeListPage(driver);
        employeeDetailPage=employeeListPage.clickToAddButton();
        employeeDetailPage.enterToFirstNameTextbox(firstName);
        employeeDetailPage.enterToLastNameTextbox(lastName);
        employeeID=employeeDetailPage.getEmployeeIDAtAddEmployeeForm();
        employeeDetailPage.clickToSaveButton();
        verifyTrue(employeeDetailPage.isFullNameDisplayAtHeader(firstName+" "+lastName));
        verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailForm(),firstName);
        verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(),lastName);
        verifyEquals(employeeDetailPage.getEmployeeIDValueAtPersonalDetailForm(),employeeID);
    }
    @Test
    public void Employee_02_Search_Employee(){

        

    }
    @Test
    public void Employee_03_Edit_Employee_By_Personal(){

    }
    @Test
    public void Employee_04_Edit_Employee_By_Contract(){

    }@Test
    public void Employee_05_Edit_Employee_By_Job(){
    }
    @Test
    public void Employee_06_Edit_Employee_By_Salary(){

    }
    @Test
    public void Employee_07_Add_User_To_Employee(){

    }
    @Test
    public void Employee_08_Search_User(){

    }
}
