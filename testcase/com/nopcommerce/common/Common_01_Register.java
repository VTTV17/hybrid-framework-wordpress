package com.nopcommerce.common;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Common_01_Register extends BaseTest {
    WebDriver driver;
    String projectLocation= System.getProperty("user.dir");
    HomePageObject homePage;
    RegisterPageObject registerPage;
   public static String email;
    public static String passWord;
    @BeforeTest
    public void beforeTest() {
        driver= getBrowserDriver("chrome");
        homePage=PageGeneratorManager.getHomePage(driver);
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        email= "test"+getRandomNumber()+"@mailnesia.com";
        passWord="test1234";
        log.info("Common - Step 1: Click on Register link");
        registerPage= homePage.clickToRegisterLink();

        log.info("Common - Step 2: Input to first name with value: first name");
        registerPage.enterToFirstName("first name");

        log.info("Common - Step 3: Input to last name with value: last name");
        registerPage.enterToLastName("last name");

        log.info("Common - Step 4: Input to email with value: "+email);
        registerPage.enterToEmailTextbox(email);

        log.info("Common - Step 5: Input to passWord with value: "+passWord);
        registerPage.enterToPasswordTextbox(passWord);

        log.info("Common - Step 6: Input to comfirm passWord with value: "+passWord);
        registerPage.enterToComfirmPasswordTextbox(passWord);

        log.info("Common - Step 7: Click on Register button");
        registerPage.clickToRegisterButton();

        log.info("Common - Step 8: Verify success message display");
        Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

        driver.quit();
    }
    @AfterClass
    public void afterTest(){
        closeBrowserAndDriver(driver);
    }

    public int getRandomNumber() {
        Random rand= new Random();
        return rand.nextInt(99999);
    }

}