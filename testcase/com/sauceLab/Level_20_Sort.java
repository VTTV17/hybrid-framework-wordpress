package com.sauceLab;

import com.nopcommerce.data.UserDataTest;
import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.NopCommerce.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_20_Sort extends BaseTest {
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
	UserDataTest userData;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver= getBrowserDriver(browserName);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

	}


	public int getRandomNumber() {
		Random rand= new Random();
		return rand.nextInt(99999);
	}
	
}