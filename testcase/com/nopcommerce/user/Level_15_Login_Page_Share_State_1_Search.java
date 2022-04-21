package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_15_Login_Page_Share_State_1_Search extends BaseTest {
    WebDriver driver;
    String projectLocation= System.getProperty("user.dir");
    HomePageObject homePage;
    RegisterPageObject registerPage;
    LoginPageObject loginPage;
    CustomerInfoPageObject customerInfoPage;
    SiteMapPageObject siteMapPage;
    NewsPageObject newsPage;
    AboutUsPageObject aboutUsPage;

    @BeforeClass
    public void beforeClass() {
        driver= getBrowserDriver("chrome");
        homePage=PageGeneratorManager.getHomePage(driver);
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage=homePage.clickToLoginLink();
        loginPage.enterToEmailTextbox(Common_01_Register.email);
        loginPage.enterToPasswordTextbox(Common_01_Register.passWord);
        homePage= loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_01_Search_Product_With_Name() {

    }
    	@Test
    public void User_02_Search_Product_With_Category() {

    }
    	@Test
    public void User_03_Search_Product_With_Price() {

    }

    public int getRandomNumber() {
        Random rand= new Random();
        return rand.nextInt(99999);
    }

}