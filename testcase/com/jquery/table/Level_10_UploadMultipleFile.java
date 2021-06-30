package com.jquery.table;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;
import pageUis.jQuery.HomePageUI;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Level_10_UploadMultipleFile extends BaseTest {
	WebDriver driver;
	private HomePageObject homePage;
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browser, String url) {
		driver= getBrowserDriver(browser);
		driver.get(url);
		homePage= PageGeneratorManager.getHomePage(driver);
	}
	@Test
	public void Upload_01_One_File_Per_Time() {
		String[] fileNames= {"flower1.jpg"};
		homePage.uploadMultipleFile(driver,HomePageUI.INPUT_UPLOAD_FILE,fileNames);
		Assert.assertTrue(homePage.areFileNameLoadedSuccess(fileNames));
		homePage.clickToAllStartButton(fileNames);
		Assert.assertTrue(homePage.areFileNameUploadedSuccess(fileNames));
	}
	@Test
	public void Upload_01_Mul_File_Per_Time() {
		String[] fileNames= {"flower1.jpg","flower2.jpg"};
		homePage.uploadMultipleFile(driver,HomePageUI.INPUT_UPLOAD_FILE,fileNames);
		Assert.assertTrue(homePage.areFileNameLoadedSuccess(fileNames));
		homePage.clickToAllStartButton(fileNames);
		Assert.assertTrue(homePage.areFileNameUploadedSuccess(fileNames));
	}
}
