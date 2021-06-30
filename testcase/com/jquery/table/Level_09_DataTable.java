package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest{
	WebDriver driver;
	private HomePageObject homePage;
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeClass(String browserName, String url) {
		driver= getBrowserDriver(browserName);
		driver.get(url);
		homePage= PageGeneratorManager.getHomePage(driver);
	}
//	@Test
	public void Table_01_Paging() {
		homePage.openPageByNumber("4");
		Assert.assertTrue(homePage.isPageActiveByNumber("4"));
	}
	@Test
	public void Table_02_Search() {
		homePage.inputToHeaderTexbox("Females","384187");
		Assert.assertTrue(homePage.areRowRecorDisplay("384187","Afghanistan","407124","791312"));
		homePage.refresh(driver);
		sleepInSecond(2);
		homePage.inputToHeaderTexbox("Country","Afghanistan");
		Assert.assertTrue(homePage.areRowRecorDisplay("384187","Afghanistan","407124","791312"));
		homePage.refresh(driver);
		sleepInSecond(2);
		homePage.inputToHeaderTexbox("Males","407124");
		Assert.assertTrue(homePage.areRowRecorDisplay("384187","Afghanistan","407124","791312"));
		homePage.refresh(driver);
		sleepInSecond(2);
		homePage.inputToHeaderTexbox("Total","791312");
		Assert.assertTrue(homePage.areRowRecorDisplay("384187","Afghanistan","407124","791312"));
		homePage.refresh(driver);
	}
	@Test
	public void Table_03_Edit_Delete() {
		homePage.clickToIconByCountry("Argentina","edit");
		homePage.refresh(driver);
		sleepInSecond(2);
		
		homePage.clickToIconByCountry("Algeria","remote");
		homePage.refresh(driver);
		sleepInSecond(2);
	}
	@Test
	public void Table_04_Edit_Delete() {
		
		homePage.openPageURL("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.inputToTextboxByColumnNameAtRowNumber("Contact Person","4","AUTO");
		sleepInSecond(2);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Company","3","Test");
		sleepInSecond(2);

	}
}
