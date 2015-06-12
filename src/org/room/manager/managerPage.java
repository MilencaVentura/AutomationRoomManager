package org.room.manager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.room.manager.utils.configReader;

public class managerPage {
	private static managerPage manager = null;
	private WebDriver driver;
	private WebDriver Chrome=null;
	private WebDriver Mozilla;
	Logger log = Logger.getLogger(getClass());
	protected managerPage() {
		PropertyConfigurator.configure("log4j.properties");
	}
	public WebDriver openBrowser(){
		if(Chrome==null){
		    log.info("Initialization of Chrome Explorer driver.");
		    System.setProperty("webdriver.chrome.driver", configReader.getChromeDriver());
			driver=new ChromeDriver();
			Chrome = driver;
		}
		driver.manage().window().maximize();
		return driver;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public static managerPage getManager() {
		if (manager == null) {
			manager = new managerPage();
		}
		return manager;
	}
}
