package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import com.nopcommerce.common.Common_02_Cookie_Register;
import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LoginPageObject;
import pageObjects.NopCommerce.PageGeneratorManager;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_15_Login_Page_Cookies extends BaseTest {
    WebDriver driver;
    String projectLocation= System.getProperty("user.dir");
    HomePageObject homePage;
    LoginPageObject loginPage;

    @BeforeClass
    public void beforeClass() {
        driver= getBrowserDriver("chrome");
        log.info("Pre-condition - Step 1: Open Login Page");
        homePage=PageGeneratorManager.getHomePage(driver);
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        log.info("Pre-Condition - Step 2: Login by cookie");
       for (Cookie cookie: Common_02_Cookie_Register.allCookies){
           driver.manage().addCookie(cookie);
       }
       log.info("Pre-condition - Step 3: Verify my account link displayed");
        homePage.refreshCurrentPage(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }
    @Test
    public void User_01_Sort_Name_Ascending() {

    }
    	@Test
    public void User_02_Sort_Name_Descending() {

    }
    	@Test
    public void User_03_Sort_Price_Ascending() {

    }
    @Test
    public void User_04_Sort_Price_Descending(){

    }

    public int getRandomNumber() {
        Random rand= new Random();
        return rand.nextInt(99999);
    }

}