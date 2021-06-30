package pageUis.jQuery;

public class HomePageUI {
	public static final String HOME_PAGE_BY_NUMBER="//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public static final String HOME_PAGE_ACTIVE_BY_NUMBER="//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL="//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_VALUE_BY_ALL_FIELDS="//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ACTION_ICON_BY_NAME="//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String HEADER_NAME_PRECEDING="//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_AT_ROW="//tr[%s]/td[%s]//input";
	
	public static final String INPUT_UPLOAD_FILE="//input[@type='file']";
	public static final String FILENAME_LOADED="//p[@class='name' and text()='%s']";
	public static final String START_BUTTON_BY_FILENAME="//p[@class='name' and text()='%s']/parent::td/following-sibling::td//button[contains(@class,'start')]";
	public static final String FILENAME_UPLOADED="//p[@class='name' ]//a[text()='%s']";
	public static final String START_BUTTON="//table//button[contains(@class,'start')]";
}
