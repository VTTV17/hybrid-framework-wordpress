package javaBasic;

public class Topic_02_Dynamic_Locator {
	//Không cần định nghĩa nhiều biến cho Locator cùng loại
	public static final String DYNAMIC_FOOTER_LINK="//[text()='%s']";
	//Dùng 1 locator để	định nghĩa cho cả header/ footer
	public static final String DYNAMIC_LINK="//div[@class='%s']//a[text()='%s']";
	public static final String DYNAMIC_COUNTRY="//td[@data-key='females' and text()='%s'/following-sibling::td[@data-key='country' and text()='%s']";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clickToElement(DYNAMIC_FOOTER_LINK,"About us");
		clickToElement(DYNAMIC_FOOTER_LINK,"New product");
		//Header
		clickToElement(DYNAMIC_LINK,"header","Register");
		clickToElement(DYNAMIC_LINK,"header","Log in");
		clickToElement(DYNAMIC_LINK,"header","My Account");
		//Footer
		clickToElement(DYNAMIC_LINK,"footer", "About us");
		clickToElement(DYNAMIC_LINK,"footer","New product");
		//
		clickToElement(DYNAMIC_COUNTRY, "female", "country", "male", "total");
	}
	//Abstract Page (Base Page)
	public static void clickToElement(String locator) {
		System.out.println(locator);
	}
	//Có 1 tham số động
	public static void clickToElement(String locator, String pageName) {
		System.out.println(String.format(locator, pageName));
	}
	//Có 2 tham số động
	public static void clickToElement(String locator, String panel, String pageName) {
		System.out.println(String.format(locator, panel,pageName));
	}
	//Có 4 tham số
//	public static void clickToElement(String locator, String female, String country, String male, String total) {
//		
//		System.out.println(String.format(locator, female, country, male, total));
//	}
	//Apply n tham số
	//Tham số đứng cuối cùng
	// Phải cùng kiểu dữ liệu khi truyền vào
	public static void clickToElement(String locator, String...values) {
		System.out.println(String.format(locator, (Object[])values));
	}
	
}
