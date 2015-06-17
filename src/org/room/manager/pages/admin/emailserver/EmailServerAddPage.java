package org.room.manager.pages.admin.emailserver;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.room.manager.modules.admin.emailserver.EmailServerAddEnum;
import org.room.manager.modules.admin.emailserver.EmailServerEnum;
import org.room.manager.pages.admin.HomeAdminPage;

/**
 * This page is for add a email server. 
 * @author Milenca Ventura
 */
public class EmailServerAddPage {
	private WebDriver driver;
    By txtHostname = EmailServerAddEnum.TXTHOSTNAME.value;
    By txtUsername = EmailServerAddEnum.TXTUSERNAME.value;
    By txtPassword = EmailServerAddEnum.TXTPASSWORD.value;
    By btnOk = EmailServerAddEnum.BTNOK.value;
	public EmailServerAddPage (WebDriver driver){
		this.driver = driver;
	}
    public EmailServerAddPage txt_Hostname(String hostname){
    	WebElement element = driver.findElement(txtHostname);
	    element.clear();
	    element.sendKeys(hostname);
	    return this;
    }
    
    public EmailServerAddPage txt_Username(String username){
    	WebElement element = driver.findElement(txtUsername);
	    element.clear();
	    element.sendKeys(username);
	    return this;
    }
    
    public EmailServerAddPage txt_Password(String password){
    	WebElement element = driver.findElement(txtPassword);
	    element.clear();
	    element.sendKeys(password);
	    return this;
    }
    public EmailServerPage btn_Save(){
    	WebElement element = driver.findElement(btnOk);
	    element.click();
	    return new EmailServerPage(driver);
    }
}
