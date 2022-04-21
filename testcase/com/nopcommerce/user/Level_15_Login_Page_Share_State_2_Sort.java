package com.nopcommerce.user;

import com.nopcommerce.common.Common_01_Register;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_15_Login_Page_Share_State_2_Sort extends BaseTest {
    WebDriver driver;
    String projectLocation= System.getProperty("user.dir");
    HomePageObject homePage;
    LoginPageObject loginPage;

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