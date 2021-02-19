package com.wordpress.posts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;
import pageUis.LoginPageUI;

public class Level_03_Login_BasePage_01{
	WebDriver driver;
	String projectLocation= System.getProperty("user.dir");
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	@Test
	public void Login_01_Empty_Email_Username() {
		loginPage.inputToUsernameTextbox("");
		loginPage.clickToContinueButton();
		assertTrue(loginPage.isEmptyEmailErrorMessageDisplay());
	}
	@Test
	public void Login_02_Invalid_Email() throws InterruptedException {
		loginPage.inputToUsernameTextbox("www@#gh");
		loginPage.clickToContinueButton();
		String error= loginPage.getInvalidEmailErrorMessage();
		sleepInSecond(3);
		assertEquals(error.trim(), "User does not exist. Would you like to create a new account?");
	}
	@Test
	public void Login_03_Username_Not_Exist() throws InterruptedException {
		loginPage.inputToUsernameTextbox("auto"+getRandom());
		loginPage.clickToContinueButton();
		sleepInSecond(3);
		String error= loginPage.getInvalidEmailErrorMessage();
		assertEquals(error.trim(), "User does not exist. Would you like to create a new account?");
	}
	@Test
	public void Login_04_Empty_Password() throws InterruptedException {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		sleepInSecond(3);
		String error= loginPage.getInvalidEmailErrorMessage();
		assertEquals(error.trim(), "Don't forget to enter your password.");
	}
	@Test
	public void Login_05_Invalid_Password() throws InterruptedException {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.inputToPasswordTextbox("2222");
		loginPage.clickToLoginButton();
		sleepInSecond(3);
		String error= loginPage.getInvalidEmailErrorMessage();
		assertEquals(error.trim(), "Oops, that's not the right password. Please try again!");
	}
	@Test
	public void Login_06_Incorrect_Password() throws InterruptedException {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.inputToPasswordTextbox("22223333");
		loginPage.clickToLoginButton();
		sleepInSecond(3);
		String error= loginPage.getInvalidEmailErrorMessage();
		assertEquals(error.trim(), "Oops, that's not the right password. Please try again!");
	}
	@Test
	public void Login_07_Valid_Email_Password() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueButton();
		loginPage.inputToPasswordTextbox("automationfc");
		loginPage.clickToLoginButton();
		sleepInSecond(3);
		dashboardPage= new DashboardPageObject(driver);
		assertTrue(dashboardPage.isDashboardTitleDisplay());
	}
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",projectLocation+"\\browserDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		loginPage= new LoginPageObject(driver);
		driver.get( "http://automationfc.wordpress.com/wp-admin");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public int getRandom() {
		Random rand= new Random();
		return rand.nextInt(99999);
	}
	public void sleepInSecond(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {

	}
	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://automationfc.wordpress.com/wp-admin");
	}
}
