package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.NopCommerce.CustomerInfoPageObject;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LoginPageObject;
import pageObjects.NopCommerce.PageGeneratorManager;
import pageObjects.NopCommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Login_Generator_Manager_PartIII {
	WebDriver driver;
	String projectLocation= System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	String email;
	String passWord;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",projectLocation+"\\browserDriver\\chromedriver.exe");
		driver= new ChromeDriver();
				
		homePage=PageGeneratorManager.getHomePage(driver);
		driver.get("http://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		email= "test"+getRandomNumber()+"@mailnesia.com";
		passWord="test1234";
	}
	@Test
	public void User_01_Register_To_System() {
		registerPage= homePage.clickToRegisterLink();
		registerPage.enterToFirstName("first name");
		registerPage.enterToLastName("last name");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(passWord);
		registerPage.enterToComfirmPasswordTextbox(passWord);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage= registerPage.clickToLogOutLink();
	}
	@Test
	public void User_02_Login_To_System() {
		loginPage=homePage.clickToLoginLink();	
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(passWord);
		homePage= loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}
	@Test
	public void User_03_Customer_Info_Page() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "first name");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), "last name");
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);

	}
	public int getRandomNumber() {
		Random rand= new Random();
		return rand.nextInt(99999);
	}

}
