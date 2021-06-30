package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.NopCommerce.AboutUsPageObject;
import pageObjects.NopCommerce.CustomerInfoPageObject;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LoginPageObject;
import pageObjects.NopCommerce.NewsPageObject;
import pageObjects.NopCommerce.PageGeneratorManager;
import pageObjects.NopCommerce.RegisterPageObject;
import pageObjects.NopCommerce.SiteMapPageObject;

public class Level_13_Login_Page_Log_Report_HTML extends BaseTest {
	WebDriver driver;
	String projectLocation= System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	SiteMapPageObject siteMapPage;
	NewsPageObject newsPage;
	AboutUsPageObject aboutUsPage;
	String email;
	String passWord;
	@BeforeClass
	public void beforeClass() {
		driver= getBrowserDriver("chrome");
		homePage=PageGeneratorManager.getHomePage(driver);
		driver.get("http://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		email= "test"+getRandomNumber()+"@mailnesia.com";
		passWord="test1234";
	}
	@Test
	public void User_01_Register_To_System() {
		log.info("Register - Step 1: Click on Register link");
		registerPage= homePage.clickToRegisterLink();
		
		log.info("Register - Step 2: Input to first name with value: first name");
		registerPage.enterToFirstName("first name");
		
		log.info("Register - Step 3: Input to last name with value: last name");
		registerPage.enterToLastName("last name");
		
		log.info("Register - Step 4: Input to email with value: "+email);
		registerPage.enterToEmailTextbox(email);
		
		log.info("Register - Step 5: Input to passWord with value: "+passWord);
		registerPage.enterToPasswordTextbox(passWord);
		
		log.info("Register - Step 6: Input to comfirm passWord with value: "+passWord);
		registerPage.enterToComfirmPasswordTextbox(passWord);
		
		log.info("Register - Step 7: Click on Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 8: Verify success message display");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Register - Step 7: Click on logout link");
		homePage= registerPage.clickToLogOutLink();
	}
//	@Test
	public void User_02_Login_To_System() {
		loginPage=homePage.clickToLoginLink();	
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(passWord);
		homePage= loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}
//	@Test
	public void User_03_Customer_Info_Page() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "first name");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), "last name");
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);

	}
//	@Test
	public void User_05_Dynamic_More_Page_Locator() {
		 customerInfoPage.openDynamicMorePage(driver, "News");
		 newsPage= PageGeneratorManager.getNewsPage(driver);
		newsPage.openDynamicMorePage(driver, "Sitemap");
		siteMapPage= PageGeneratorManager.getSiteMapPage(driver);
		siteMapPage.openDynamicMorePage(driver, "About us");
		aboutUsPage=PageGeneratorManager.getAboutUsPage(driver);
	}
//	@Test
	public void User_04_Dynamic_Page_Locator() {
		newsPage= (NewsPageObject) customerInfoPage.openFooterPageByName(driver, "News");
		siteMapPage= (SiteMapPageObject)newsPage.openFooterPageByName(driver, "Sitemap");
		aboutUsPage=(AboutUsPageObject) siteMapPage.openFooterPageByName(driver, "About us");
		
	}
	public int getRandomNumber() {
		Random rand= new Random();
		return rand.nextInt(99999);
	}
	
}