package org.room.manager;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.utils.configReader;

public class managerPage {
	private static managerPage manager = new managerPage();
	private static WebDriver driver;

	private managerPage() {
	}
	/**
	 * This method is for get a chorme browser
	 * @return driver 
	 */
	public static WebDriver getBrowserChrome(){
		if(driver == null || (driver.toString().contains("(null)"))){
		    System.setProperty("webdriver.chrome.driver", configReader.getChromeDriver());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	/**
	 * This method for get a instance of browser
	 * @return manager 
	 */
	public static managerPage getManager(){
		return manager;
	}
}
