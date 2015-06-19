package org.room.manager.pages.admin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.LoginEnum;;

/**
 * This page is for login to Room Manager
 * @author Milenca Ventura
 */
public class LoginPage {

	private WebDriver driver;
	By linkResource = LoginEnum.BTNLOGIN.value;
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	/**
	 * This method do click on login button
	 * @return HomeAdminPage
	 */
    public HomeAdminPage  btn_signIn(){
    	(new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(linkResource));
    	WebElement element = driver.findElement(linkResource);
    	element.click();
	    return new HomeAdminPage(driver);
    }
}
