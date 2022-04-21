package pageObjects.SauceLab;


import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static PageGeneratorManager getPageGenerator() {
		return new PageGeneratorManager();
	}
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);

	}

}
