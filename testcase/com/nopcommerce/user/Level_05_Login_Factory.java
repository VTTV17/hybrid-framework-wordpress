package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.NopCommerce.HomePageObject;
import pageFactory.NopCommerce.LoginPageObject;
import pageFactory.NopCommerce.RegisterPageObject;


public class Level_05_Login_Factory extends BaseTest{
	WebDriver driver;
	String projectLocation= System.getProperty("user.dir");
	HomePageObject homePage;
	String email;
	String passWord;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser, String urlName) {
		driver= getBrowserDriver(browser);
		driver.get(urlName);
		homePage= new HomePageObject(driver);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		email= "test"+getRandomNumber()+"@mailnesia.com";
		passWord="test1234";
	}
	@Test
	public void User_01_Register_To_System() {
		homePage.clickToRegisterLink();
		registerPage= new RegisterPageObject(driver);
		registerPage.enterToFirstName("first name");
		registerPage.enterToLastName("last name");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(passWord);
		registerPage.enterToComfirmPasswordTextbox(passWord);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		registerPage.clickToLogOutLink();
		homePage= new HomePageObject(driver);
	}
	@Test
	public void User_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage= new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(passWord);
		loginPage.clickToLoginButton();
		homePage= new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}
	public int getRandomNumber() {
		Random rand= new Random();
		return rand.nextInt(99999);
	}
}
