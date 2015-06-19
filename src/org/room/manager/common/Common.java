package org.room.manager.common;

import org.openqa.selenium.WebDriver;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;

/**
 * This class contain the refresh page for Room Manager
 * @author Milenca Ventura
 *
 */
public class Common {
	/**
	 * This method Refresh the page going to another link, email server.
	 * @param driver
	 * 
	 */
	public void Refresh(WebDriver driver){
		HomeAdminPage home = new HomeAdminPage(driver);
		home.lnk_EmailServer();
	}
	/**
	 * This method Refresh the page going to another link, email server.
	 * @param driver
	 * 
	 */
	public void RefreshPage(WebDriver driver){
		HomeAdminPage home = new HomeAdminPage(driver);
		home.lnk_Resources();
	}
}
