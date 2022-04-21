package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_17_Login_Pattern_Object extends BaseTest {
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
	public void User_01_Validate_At_Register_Form(){
		log.info("Validate - Step 1: Click on Register link");
		registerPage= homePage.clickToRegisterLink();

		log.info("Validate - Step 2: Click on Register button");
		registerPage.clickToButtonByValue(driver,"Register");

		log.info("Validate - Step 3: Verify error message display at first name");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver,"FirstName"),"First name is require");

		log.info("Validate - Step 4: Verify error message display at last name");
		verifyEquals(registerPage.getErrorMessageAtMandantoryFieldByID(driver,"LastName"),"Last name is require");


	}
	@Test
	public void User_02_Register_To_System() {
		log.info("Register - Step 1: Click on Register link");
		registerPage= homePage.clickToRegisterLink();
		
		log.info("Register - Step 2: Input to first name with value: first name");
		registerPage.inputToTextboxByID(driver,"FirstName","first name");

		log.info("Register - Step 3: Input to last name with value: last name");
		registerPage.inputToTextboxByID(driver,"LastName","last name");
		
		log.info("Register - Step 4: Input to email with value: "+email);
		registerPage.inputToTextboxByID(driver,"Email",email);
		
		log.info("Register - Step 5: Input to passWord with value: "+passWord);
		registerPage.inputToTextboxByID(driver,"Password",passWord);
		
		log.info("Register - Step 6: Input to comfirm passWord with value: "+passWord);
		registerPage.inputToTextboxByID(driver,"ConfirmPassword",passWord);
		
		log.info("Register - Step 7: Click on Register button");
		registerPage.clickToButtonByValue(driver,"Register");
		
		log.info("Register - Step 8: Verify success message display");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Register - Step 7: Click on logout link");
		homePage= registerPage.clickToLogOutLink();
	}
	@Test
	public void User_03_Login_To_System() {
		loginPage=homePage.clickToLoginLink();	
		loginPage.inputToTextboxByID(driver,"Email",email);
		loginPage.inputToTextboxByID(driver,"Password",passWord);

		loginPage.clickToButtonByValue(driver,"Log in");
		homePage=PageGeneratorManager.getHomePage(driver);
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