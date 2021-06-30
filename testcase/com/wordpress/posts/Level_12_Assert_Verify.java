package com.wordpress.posts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_12_Assert_Verify extends BaseTest {
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	WebDriver driver;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass( String browser, String url) {
		driver= getBrowserDriver("chrome");
		driver.get(url);
	}
	@Test
	public void Login_01_Assert() {
		System.out.println("Step 1 Fail");
	assertTrue(false);
	System.out.println("Step 2 pass");

	assertTrue(true);
	}
	@Test
	public void Login_02_Verify() {
		System.out.println("Step 1 Fail");

		verifyFalse(true);
		System.out.println("Step 2 pass");

		verifyTrue(true);
	}

}
