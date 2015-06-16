package org.room.manager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.room.manager.utils.configReader;

public class managerPage {
	private static managerPage manager = new managerPage();
	private static WebDriver driver = null;
	//Logger log = Logger.getLogger(getClass());
	protected managerPage() {
		//PropertyConfigurator.configure("log4j.properties");
	}

	public static WebDriver getBrowserChrome(){
		if(driver == null){
		    System.setProperty("webdriver.chrome.driver", configReader.getChromeDriver());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	public static WebDriver getBrowserMozilla(){
		if(driver == null){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	public static managerPage getManager(){
		return manager;
	}
	/*public static managerPage getManager() {
		if (manager == null) {
			manager = new managerPage();
		}
		return manager;
	}*/
}
