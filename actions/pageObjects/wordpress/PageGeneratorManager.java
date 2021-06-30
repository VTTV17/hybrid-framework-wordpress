package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static PageGeneratorManager getPageGenerator() {
		return new PageGeneratorManager();
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);				
	}
	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	
}
