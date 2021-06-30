package commons;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.NopCommerce.AboutUsPageObject;
import pageObjects.NopCommerce.NewsPageObject;
import pageObjects.NopCommerce.PageGeneratorManager;
import pageObjects.NopCommerce.SiteMapPageObject;
import pageUis.nopCommerce.BasePageUI;

public class BasePage {
	private long longTimeOut= GlobalConstants.LONG_TIMEOUT;
	private long shortTimeOut= GlobalConstants.SHORT_TIMEOUT;
	public static BasePage getBasePage() {
		return new BasePage();
	}
	public String getDynamicLocator(String locator, String... values) {
		return String.format(locator, (Object[])values);
	}
	public void openPageURL(WebDriver driver,String url) {
		driver.get(url);
	}
	public  String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void waitAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void exceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void sendKeyToAlert(WebDriver driver, String key) {
		driver.switchTo().alert().sendKeys(key);
	}
	public void switchToWindowByID(WebDriver driver, String idWindown) {
		Set<String> allWindow= driver.getWindowHandles();
		for(String window: allWindow) {
			if(!window.equals(idWindown)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindow= driver.getWindowHandles();
		for(String window: allWindow) {
			driver.switchTo().window(window);
			if(driver.getTitle().equals(title)) {				
				break;
			}
		}
	}
	public void closeAllWindownsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows= driver.getWindowHandles();
		for(String window: allWindows) {
			if(!window.equals(parentID)) {
				driver.switchTo().window(parentID);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	public List<WebElement> getWebElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	public List<WebElement> getWebElements(WebDriver driver, String locator, String...values) {
		return driver.findElements(getByXpath(getDynamicLocator(locator, values)));
	}
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	public void clickToElement(WebDriver driver, String locator) {
		 getWebElement(driver, locator).click();
	}
	public void clickToElement(WebDriver driver, String locator, String... values) {
		 getWebElement(driver, getDynamicLocator(locator, values)).click();
	}
	public void clickToElement(WebElement element) {
		 element.click();
	}
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getWebElement(driver, locator).sendKeys(value);
	}
	public void sendKeyToElement(WebDriver driver, String locator,String value, String...values) {
		getWebElement(driver, getDynamicLocator(locator, values)).sendKeys(value);
	}
	public void uploadMultipleFile(WebDriver driver, String locator, String...fileNames) {
		String filePath= System.getProperty("user.dir")+getDirectorySlash("uploadFile");
		String fullFileName="";
		for(String file: fileNames) {
			fullFileName= fullFileName+ filePath+file+"\n";
		}
		fullFileName=fullFileName.trim();
		sendKeyToElement(driver, locator, fullFileName);
	}
	public String getDirectorySlash(String folderName) {
		String separator= FileSystems.getDefault().getSeparator();
		separator= System.getProperty("file.separator");
		return File.separator +folderName+ File.separator;
	}
	public void selectItemInDropdown(WebDriver driver, String locator, String itemText) {
		WebElement element= getWebElement(driver, locator);
		Select select= new Select(element);
		select.selectByVisibleText(itemText);
	}
	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		Select select= new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select= new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}
	public void selectItemInCustomDropdown(WebDriver driver, String parenrLocator, String childLocator, String expectItem) {
		clickToElement(driver, parenrLocator);
		sleepInSecond(3);
		WebDriverWait explicitWait= new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
		List<WebElement> allElement= getWebElements(driver, childLocator);
		for(WebElement element: allElement) {
			if(element.getText().equals(expectItem)) {
				JavascriptExecutor executor= (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", element);
				sleepInSecond(1);
				clickToElement(element);
			}
		}
	}
	public void sleepInSecond(int second) {
		try {
			Thread.sleep(1000*second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		return getWebElement(driver, locator).getAttribute(attribute);
	}
	public String getTextElement(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	public String getTextElement(WebDriver driver, String locator, String...values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).getText();
	}
	public int getElementSize(WebDriver driver, String locator) {
		return getWebElements(driver, locator).size();
	}
	public int getElementSize(WebDriver driver, String locator, String...values) {
		return getWebElements(driver, getDynamicLocator(locator, values)).size();
	}
	public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element= getWebElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	public void uncheckTheCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element= getWebElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		boolean status=false;
		try {
			status= getWebElement(driver, locator).isDisplayed();
			return status;
		} catch (Exception e) {
			return status;
		}
	}
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overideImplicitTimeout(driver, shortTimeOut);
		List<WebElement> elements= getWebElements(driver, locator);
		overideImplicitTimeout(driver, longTimeOut);
		if(elements.size()==0) {
			System.out.println("Element not in DOM");
			return true;
		}else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/displayed");
			return true;
		}else {
			System.out.println("Element in DOM and visible/displayed");
			return false;
		}
	}
	public boolean isElementUndisplayed(WebDriver driver, String locator, String...values) {
		overideImplicitTimeout(driver, shortTimeOut);
		List<WebElement> elements= getWebElements(driver, getDynamicLocator(locator, values));
		overideImplicitTimeout(driver, longTimeOut);
		if(elements.size()==0) {
			System.out.println("Element not in DOM");
			return true;
		}else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/displayed");
			return true;
		}else {
			System.out.println("Element in DOM and visible/displayed");
			return false;
		}
	}
	public void overideImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
	public void switchToDefaultContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}
	public void hoverToElement(WebDriver driver, String locator) {
		Actions action= new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}
	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}
	public void drapAndDropELement(WebDriver driver, String targetLocator, String sourceLocator) {
		Actions action= new Actions(driver);
		action.dragAndDrop(getWebElement(driver,sourceLocator ), getWebElement(driver, targetLocator)).perform();
	}
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		Actions action= new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key,String...values) {
		Actions action= new Actions(driver);
		action.sendKeys(getWebElement(driver,getDynamicLocator(locator, values)), key).perform();
	}
	public Object executeForBrowser(WebDriver driver, String javascript) {
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		return (String) executor.executeScript(javascript);
	}
	public String getInnerText(WebDriver driver) {
		return (String) executeForBrowser(driver, "return document.documentElement.innerText;");
	}
	public boolean areExpectedTextInnerText(WebDriver driver, String textExpected) {
		String textActual =(String) executeForBrowser(driver, "return document.documentElement.innerText.match('"+textExpected+"')[0]");
		return textActual.equals(textExpected);
	}
	public void scrollBottomPage(WebDriver driver) {
		executeForBrowser(driver, "window.scrollBy(0,document.body.scrollHeight)");
	}
	public void navigateToURLByJS(WebDriver driver, String url) {
		executeForBrowser(driver, "window.location='"+url+"'");
	}
	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	
	}
	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForElementVisible(WebDriver driver, String locator, String...values) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}
	public void waitForListElementVisble(WebDriver driver, String locator) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForElementInvisible(WebDriver driver, String locator, String...values) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}
	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator, String...values) {
		WebDriverWait explicitWait= new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}
	// commons page
	public SiteMapPageObject openSiteMapPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SITE_MAP_LINK);
		clickToElement(driver, BasePageUI.SITE_MAP_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);
	}
	public NewsPageObject openNewsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.NEWS_LINK);
		clickToElement(driver,BasePageUI.NEWS_LINK);
		return PageGeneratorManager.getNewsPage(driver);
	}
	public AboutUsPageObject openAboutUsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ABOUT_US_LINK);
		clickToElement(driver, BasePageUI.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);
	}
	// Dynamic Locator - Cach 1- it page
	public BasePage openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK, pageName);
		clickToElement(driver, BasePageUI.FOOTER_PAGE_LINK, pageName);
		if(pageName.equals("Sitemap")) {
			return PageGeneratorManager.getSiteMapPage(driver);
		}else if(pageName.equals("News")) {
			return PageGeneratorManager.getNewsPage(driver);
		}else if(pageName.equals("About us")) {
			return PageGeneratorManager.getAboutUsPage(driver);
		}else {
			throw new RuntimeException("Please input correct page name!");
		}
	}
	public void openDynamicMorePage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUI.FOOTER_PAGE_LINK, pageName);
		clickToElement(driver, BasePageUI.FOOTER_PAGE_LINK, pageName);
	}
}
