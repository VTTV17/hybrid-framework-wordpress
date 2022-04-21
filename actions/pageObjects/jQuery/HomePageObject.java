package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUis.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderTexbox(String labelName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, labelName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, labelName);
		sendKeyBoardToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, labelName);
	}

	public boolean areRowRecorDisplay(String females, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELDS, females,country,male,total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELDS, females,country,male,total);
	}

	public void clickToIconByCountry(String country, String action) {
		waitForElementInvisible(driver, HomePageUI.ACTION_ICON_BY_NAME, country,action);
		clickToElement(driver, HomePageUI.ACTION_ICON_BY_NAME, country,action);
	}

	public void openPageURL(String url) {
		navigateToURLByJS(driver, url);
	}

	public void inputToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName);
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName)+1;
		sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_AT_ROW, rowNumber,value, String.valueOf(columnIndex));
	}

	public boolean areFileNameLoadedSuccess(String[] fileNames) {
		Boolean status= false;
		for(String fileName:fileNames) {
			if(isElementDisplayed(driver, HomePageUI.FILENAME_LOADED,fileNames)) {
				status=true;
			}else {
				return status;
			}
		}
		return status;
	}

	public void clickToAllStartButton(String[]fileNames) {
		List<WebElement> listElement= getWebElements(driver,  HomePageUI.START_BUTTON);
		for(int i=0;i<listElement.size();i++) {
			listElement.get(i).click();
			sleepInSecond(2);
		}
	}

	public boolean areFileNameUploadedSuccess(String[] fileNames) {
		Boolean status= false;
		for(String fileName:fileNames) {
			if(isElementDisplayed(driver, HomePageUI.FILENAME_UPLOADED,fileNames)) {
				status=true;
			}else {
				return status;
			}
		}
		return status;
	}

	
	
}
