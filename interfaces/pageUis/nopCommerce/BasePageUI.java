package pageUis.nopCommerce;

public class BasePageUI {
	// truyền cố định tên page
	public static final String 	SITE_MAP_LINK="//a[text()='Sitemap']";
	public static final String NEWS_LINK="//a[text()='News']";
	public static final String ABOUT_US_LINK="//a[text()='About us']";
	// có 1 tham số = dynamic page name
	public static final String FOOTER_PAGE_LINK="//div[@class='footer']//a[text()='%s']";
	//
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID="//input[@id='%s']";
	public static final String DYNAMIC_INPUT_BY_ID="//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE="//button[text()='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_NAME="//span[@class='field-validation-error']/span[@id='%s-error']";
}
