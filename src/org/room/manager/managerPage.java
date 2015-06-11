package org.room.manager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
		driver=new ChromeDriver();
		Chrome = driver;
		}/*else if (Mozilla==null) {
			log.info("Initialization of Mozilla Explorer driver.");
			driver=new FirefoxDriver();*/
		else if(Chrome!=null){
			driver=Chrome;
		}
		driver.manage().window().maximize();
		return driver;
	}
	public static managerPage getManager() {
		if (manager == null || manager.driver.toString().contains("null")) {
			manager = new managerPage();
		}
		return manager;
	}
	/**
	 * Get the Web driver
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Set to null the webdriver
	 */
	public void quitDriver() {
		try {
			log.info("Set null the webdriver.");
			driver.quit();
		} catch (Exception e) {
			log.error("Unable to quit the webdriver.", e);
		}
		driver = null;
	}
}
