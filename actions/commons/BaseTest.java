package commons;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String projectLocation= System.getProperty("user.dir");
	String osName= System.getProperty("os.name");
	public WebDriver getBrowserDriver(String browser) {
//		setBrowserProperty();
		Browsers browsName= Browsers.valueOf(browser.toUpperCase());
		if(browsName==Browsers.FIREFOX) {
			WebDriverManager.firefoxdriver().arch64().setup();
			driver= new FirefoxDriver();
		}else {
			if(browsName==Browsers.CHROME) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			}else {
				if(browsName==Browsers.EDGE) {
					WebDriverManager.edgedriver().setup();
					driver= new EdgeDriver();
				}else
					if(browsName==Browsers.CHROME_HEADLESS) {
						ChromeOptions option= new ChromeOptions();
						option.addArguments("headless");
						option.addArguments("window-size=1920*1028");
						WebDriverManager.chromedriver().setup();
						driver= new ChromeDriver();
						
					}else
					throw new RuntimeException("Please input browser name");
			}
		}
		return driver;
	}
	protected int getRandom() {
		Random rand= new Random();
		return rand.nextInt(99999);
	}
	protected void sleepInSecond(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String getDirectorySlash(String folderName) {
		if(isMac()||isUnix()||isSolaris()) {
			folderName="/"+folderName+'/';
		}else if(isWindow()) {
			folderName= "\\"+folderName+"\\";
		}else {
			folderName=null;
		}
		return folderName;
	}
	private void setBrowserProperty() {
		if(isWindow()){
			System.setProperty("webdriver.chrome.driver",projectLocation+getDirectorySlash("browserDriver")+"chromedriver.exe");
			System.setProperty("webdriver.gecko.driver",projectLocation+getDirectorySlash("browserDriver")+"geckodriver.exe");
			System.setProperty("webdriver.edge.driver",projectLocation+getDirectorySlash("browserDriver")+"msedgedriver.exe");
		}else if(isMac()) {
			System.setProperty("webdriver.chrome.driver",projectLocation+getDirectorySlash("browserDriver")+"chromedriver_mac");
			System.setProperty("webdriver.gecko.driver",projectLocation+getDirectorySlash("browserDriver")+"geckodriver_mac");
			System.setProperty("webdriver.edge.driver",projectLocation+getDirectorySlash("browserDriver")+"msedgedriver_mac");
		}else {
			System.setProperty("webdriver.chrome.driver",projectLocation+getDirectorySlash("browserDriver")+"chromedriver_linux");
			System.setProperty("webdriver.gecko.driver",projectLocation+getDirectorySlash("browserDriver")+"geckodriver_linux");
			System.setProperty("webdriver.edge.driver",projectLocation+getDirectorySlash("browserDriver")+"msedgedriver_linux");
		}
	}
	private boolean isWindow() {
		return (osName.toLowerCase().indexOf("win"))>=0;
	}
	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac"))>=0;
	}
	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix"))>=0 || (osName.toLowerCase().indexOf("nux"))>=0;
	}
	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos"))>=0;
	}
}
