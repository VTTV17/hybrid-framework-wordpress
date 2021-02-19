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

public class Level_02_Login_BasePage_03 extends BasePage{
	WebDriver driver;
	String projectLocation= System.getProperty("user.dir");
	By usernameboxBy=By.id("usernameOrEmail");
	By continuteBtnBy= By.xpath("//button[text()='Continue']");
	By errorMessageBy= By.xpath("//span[text()='Please enter a username or email address.']");
	By passwordBoxBy= By.id("password");
	By loginBtnBy= By.xpath("//button[text()='Log In']");
	By errorBy= By.xpath("//div[@class='form-input-validation is-error']");
	By dashboardPageBy= By.xpath("//h1[text()='Dashboard']");
  @Test
  public void Login_01_Empty_Email_Username() {
	  sendKeyToElement(driver, "//input[@id='usernameOrEmail']", "");
	  clickToElement(driver, "//button[text()='Continue']");
	  assertTrue(isElementDisplayed(driver, "//span[text()='Please enter a username or email address.']"));
  }
  @Test
  public void Login_02_Invalid_Email() throws InterruptedException {
	  sendKeyToElement(driver, "//input[@id='usernameOrEmail']", "www@#gh");
	  clickToElement(driver, "//button[text()='Continue']");
	  String error= getTextElement(driver, "//div[@class='form-input-validation is-error']");
	  sleepInSecond(3);
	  assertEquals(error.trim(), "User does not exist. Would you like to create a new account?");
  }
  @Test
  public void Login_03_Username_Not_Exist() throws InterruptedException {
	  sendKeyToElement(driver, "//input[@id='usernameOrEmail']","auto"+getRandom());
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(3);
	  String error= getTextElement(driver, "//div[@class='form-input-validation is-error']");
	  assertEquals(error.trim(), "User does not exist. Would you like to create a new account?");
  }
  @Test
  public void Login_04_Empty_Password() throws InterruptedException {
	  sendKeyToElement(driver, "//input[@id='usernameOrEmail']","automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sendKeyToElement(driver, "//input[@id='password']","");
	  clickToElement(driver, "//button[text()='Log In']");
	  sleepInSecond(3);
	  String error= getTextElement(driver, "//div[@class='form-input-validation is-error']");
	  assertEquals(error.trim(), "Don't forget to enter your password.");
  }
  @Test
  public void Login_05_Invalid_Password() throws InterruptedException {
	  sendKeyToElement(driver, "//input[@id='usernameOrEmail']","automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sendKeyToElement(driver, "//input[@id='password']","2222");
	  clickToElement(driver, "//button[text()='Log In']");
	  sleepInSecond(3);
	  String error= getTextElement(driver, "//div[@class='form-input-validation is-error']");
	  assertEquals(error.trim(), "Oops, that's not the right password. Please try again!");
  }
  @Test
  public void Login_06_Incorrect_Password() throws InterruptedException {
	  sendKeyToElement(driver, "//input[@id='usernameOrEmail']","automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sendKeyToElement(driver, "//input[@id='password']","22223333");
	  clickToElement(driver, "//button[text()='Log In']");
	  sleepInSecond(3);
	  String error= getTextElement(driver, "//div[@class='form-input-validation is-error']");
	  assertEquals(error.trim(), "Oops, that's not the right password. Please try again!");
  }
  @Test
  public void Login_07_Valid_Email_Password() {
	  sendKeyToElement(driver, "//input[@id='usernameOrEmail']","automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sendKeyToElement(driver, "//input[@id='password']","automationfc");
	  clickToElement(driver, "//button[text()='Log In']");
	  assertTrue(isElementDisplayed(driver, "//h1[text()='Dashboard']"));
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver",projectLocation+"\\browserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  openPageURL(driver, "http://automationfc.wordpress.com/wp-admin");
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
	  openPageURL(driver, "http://automationfc.wordpress.com/wp-admin");
  }
}
