package com.wordpress.posts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.NopCommerce.PageGeneratorManager;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_11_Login_Element_Undisplay extends BaseTest {
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	WebDriver driver;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver= getBrowserDriver("chrome");
		driver.get(url);
		loginPage= pageObjects.wordpress.PageGeneratorManager.getLoginPage(driver);
	}
	@Test
	public void Login_01_Valid_Email_Password() {
		sleepInSecond(3);
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.inputToPasswordTextbox("automationfc");
		loginPage.clickToLoginButton();
		sleepInSecond(3);
		dashboardPage= pageObjects.wordpress.PageGeneratorManager.getDashboardPageObject(driver);
		assertTrue(dashboardPage.isDashboardTitleDisplay());
	}
	@Test
	public void Login_02_Element_Displayed() {
		dashboardPage.clickToScreenOptionButton();
		Assert.assertTrue(dashboardPage.isActivityCheckboxDisplayed());
		dashboardPage.clickToScreenOptionButton();
		sleepInSecond(2);
		Assert.assertFalse(dashboardPage.isActivityCheckboxUnDisplayed());
	}
	@Test
	public void Login_03_Element_Undisplayed_In_DOM() {
		Assert.assertFalse(dashboardPage.isActivityCheckboxUnDisplayed());
		sleepInSecond(2);
	}
	@Test
	public void Login_04_Element_Undisplayed_Without_DOM() {
		boolean postSearch= dashboardPage.isPostSearchTextboxUnDisplayed();
		Assert.assertTrue(postSearch);
	}
}
