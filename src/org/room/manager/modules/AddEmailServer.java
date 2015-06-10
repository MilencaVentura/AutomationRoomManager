package org.room.manager.modules;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.pages.admin.HomeAdminPage;

public class AddEmailServer {
	public static void Execute(WebDriver driver, String hostname, String username, String password){
		HomeAdminPage.lnk_EmailServer(driver).click();
	    EmailServerAddPage.btn_Add(driver).click();
	    EmailServerAddPage.txtbx_Hostname(driver).clear();
		EmailServerAddPage.txtbx_Hostname(driver).sendKeys(hostname);;
		EmailServerAddPage.txtbx_Username(driver).clear();
		EmailServerAddPage.txtbx_Username(driver).sendKeys(username);
		EmailServerAddPage.txtbx_Password(driver).clear();
		EmailServerAddPage.txtbx_Password(driver).sendKeys(password);
		EmailServerAddPage.btn_Save(driver).click();
	}
	public static void Assert(WebDriver driver, String expectedResult){
		assertEquals("The email server was not registered",expectedResult, 
				EmailServerAddPage.btn_Server(driver).getText());
	}
}
