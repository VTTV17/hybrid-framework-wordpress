package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LoginPageObject;
import pageObjects.NopCommerce.RegisterPageObject;

public class Level_03_Login_PageObject {
	WebDriver driver;
	String projectLocation= System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	String email;
	String passWord;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",projectLocation+"\\browserDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		homePage= new HomePageObject(driver);
		driver.get("http://demo.nopcommerce.com/");
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
